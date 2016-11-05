package pl.projektowa.btcbankex.actions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import pl.projektowa.btcbankex.database.actions.BankAccountActions;
import pl.projektowa.btcbankex.dbutils.CurrencyUtils;
import pl.projektowa.btcbankex.dbutils.DatabaseConnection;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.Currency;
import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class BankAccountActionsImpl implements BankAccountActions{

	public boolean isBankAccountInDatabase(int id) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", id);
		
		List<BankAccount> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		BankAccount ba;
		try {
			ba = list.get(0);
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean addBankAccountToDatabase(int userId, String code, String addr, double balance) {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	   	
		try {
			User u = new UserActionsImpl().getUserFromDatabase(userId);
			Currency c = CurrencyUtils.getCurrencyByCode(code);
			
			BankAccount a = new BankAccount(addr, balance);
			a.setUser_id(u);
			a.setCode(c);
			
			session.save(a);
			
			session.getTransaction().commit();
			session.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	public BankAccount getBankAccount(int id) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", id);
		
		List<BankAccount> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		BankAccount ba;
		try {
			ba = list.get(0);
			return ba;
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Bank Account does not exist");
		}
	}

	public List<BankAccount> getAllBankAccountsOfUser(int userId) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from User where user_id=:n");
		query.setParameter("n", userId);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
						
		try {
			User u = list.get(0);
			Set<BankAccount> bas = u.getAddresses();
			List<BankAccount> bal = new LinkedList<BankAccount>();
			bal.addAll(bas);
			return bal;
		
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean changeBalance(int id, Double changeToBalance) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", id);
		
		List<BankAccount> list = query.list();
	   					
		BankAccount ba;
		try {
			ba = list.get(0);
			ba.setBalance(ba.getBalance() + changeToBalance);
			session.update(ba);
			session.getTransaction().commit();
			session.close();
			
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	
	public boolean deleteBankAccount(int id) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from BankAccount where addr_id=:n");
		query.setParameter("n", id);
		
		List<BankAccount> list = query.list();
	   					
		BankAccount ba;
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
