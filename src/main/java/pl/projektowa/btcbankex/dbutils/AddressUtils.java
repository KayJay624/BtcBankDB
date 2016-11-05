package pl.projektowa.btcbankex.dbutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.Currency;
import pl.projektowa.btcbankex.model.User;

public class AddressUtils {
	public static boolean addAddress(int userId, String code, String addr, double balance) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	   	
		try {
			User u = UsersUtils.getUserById(userId);
			Currency c = CurrencyUtils.getCurrencyByCode(code);
			
			BankAccount a = new BankAccount(addr, balance);
			a.setUser_id(u);
			a.setCode(c);
			
			session.save(a);
			
			session.getTransaction().commit();
			session.close();
			
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public static List<BankAccount> getAllAddresses() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Address");
		
		List<BankAccount> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	public static BankAccount getAddressesById(int addr_id) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	try {
	    	Query query = session.createQuery("from Address where addr_id=:i");
			query.setParameter("i", addr_id);
	    	
			List<BankAccount> list = query.list();
		   	
	    	session.getTransaction().commit();
			session.close();
			
			return list.get(0);
    	} catch (Exception e) {
    		throw new Exception("This address does not exists");
    	}
	}
}
