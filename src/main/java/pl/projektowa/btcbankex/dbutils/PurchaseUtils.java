package pl.projektowa.btcbankex.dbutils;

import org.hibernate.Session;

import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.Currency;
import pl.projektowa.btcbankex.model.Purchase;
import pl.projektowa.btcbankex.model.User;

public class PurchaseUtils {
	public static boolean addPurchase(int userId, String curr_to_buy, String curr_to_sell, double amount, double price) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	   	
		try {
			User u = UsersUtils.getUserById(userId);
			Currency ctb = CurrencyUtils.getCurrencyByCode(curr_to_buy);
			Currency cts = CurrencyUtils.getCurrencyByCode(curr_to_sell);
			
			Purchase p = new Purchase(amount, price);
			p.setUser_id(u);
			p.setCurr_to_buy(ctb);
			p.setCurr_to_sell(cts);
			
			session.save(p);
			
			session.getTransaction().commit();
			session.close();
			
			return true;
		} catch (Exception e) {
			throw new Exception("Problem adding this PURCHASE transaction");
		}	
	}
}
