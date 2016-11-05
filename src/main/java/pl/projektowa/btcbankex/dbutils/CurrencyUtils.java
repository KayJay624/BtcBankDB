package pl.projektowa.btcbankex.dbutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pl.projektowa.btcbankex.model.Currency;

public class CurrencyUtils {
	public static Currency getCurrencyByCode(String code) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Currency where code=:c");
		query.setParameter("c", code);
		
		List<Currency> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		Currency c;
		try {
			c = list.get(0);
			return c;
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Currency does not exist");
		}		
	}
}
