package pl.projektowa.btcbankex.dbutils;

import org.hibernate.Session;

import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.Currency;
import pl.projektowa.btcbankex.model.BankTransfer;
import pl.projektowa.btcbankex.model.User;

public class TransactionUtils {
	public static boolean addTransaction(String name, int fromId, int toId, double amount) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	org.hibernate.Transaction tx = null;
    	   	
		try {
			tx = session.beginTransaction();
			BankAccount from = AddressUtils.getAddressesById(fromId);
			BankAccount to = AddressUtils.getAddressesById(toId);
			
			
			
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
			throw new Exception(e.getMessage());
		}	
	}
}
