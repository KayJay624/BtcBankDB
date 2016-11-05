package pl.projektowa.btcbankex.actions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import pl.projektowa.btcbankex.database.actions.BankTransferActions;
import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.DatabaseConnection;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.BankTransfer;
import pl.projektowa.btcbankex.model.User;

public class BankTransferActionsImpl implements BankTransferActions{

	public boolean isBankTransferInDatabase(int id) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankTransfer where transaction_id=:n");
		query.setParameter("n", id);
		
		List<BankTransfer> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		BankTransfer bt;
		try {
			bt = list.get(0);
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean addBankTransferToDatabase(String name, int fromId, int toId, double amount) {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	org.hibernate.Transaction tx = null;
    	   	
		try {
			tx = session.beginTransaction();
			BankAccount from = new BankAccountActionsImpl().getBankAccount(fromId);
			BankAccount to = new BankAccountActionsImpl().getBankAccount(toId);
					
			if(from.getBalance() >= amount && from.getCode().getCode().equals(to.getCode().getCode())) {
				BankTransfer t = new BankTransfer(name, amount);
				t.setFrom_addr(from);
				t.setTo_addr(to);
				
				from.setBalance(from.getBalance()-amount);
				to.setBalance(to.getBalance()+amount);
				session.update(from);
				session.update(to);
				
				session.save(t);
				
				session.getTransaction().commit();
				session.close();
			} else {
				throw new Exception("Biedaku polaku nie stać cie");
			}
			
			
			return true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
			return false;
		}	
	}

	public BankTransfer getBankTransfer(int id) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankTransfer where transaction_id=:n");
		query.setParameter("n", id);
		
		List<BankTransfer> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		BankTransfer bt;
		try {
			bt = list.get(0);
			return bt;
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Bank Account does not exist");
		}
	}

	public List<BankTransfer> getBankTransfersMadeToAccount(int bankAccountId) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", bankAccountId);
		
		List<BankAccount> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
						
		try {
			BankAccount u = list.get(0);
			Set<BankTransfer> bas = u.getToTransactions();
			List<BankTransfer> bal = new LinkedList<BankTransfer>();
			bal.addAll(bas);
			return bal;
		
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<BankTransfer> getBankTransfersMadeFromAccount(int bankAccountId) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", bankAccountId);
		
		List<BankAccount> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
						
		try {
			BankAccount u = list.get(0);
			Set<BankTransfer> bas = u.getFromTransactions();
			List<BankTransfer> bal = new LinkedList<BankTransfer>();
			bal.addAll(bas);
			return bal;
		
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteBankTransferFromDatabase(String id) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankTransfer where transaction_id=:n");
		query.setParameter("n", id);
		
		List<BankTransfer> list = query.list();
	   					
		BankTransfer ba;
		try {
			ba = list.get(0);
			session.delete(ba);
			session.getTransaction().commit();
			session.close();
			return true;			
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
}
