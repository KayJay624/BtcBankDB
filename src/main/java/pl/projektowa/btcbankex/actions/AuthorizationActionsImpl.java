package pl.projektowa.btcbankex.actions;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.projektowa.btcbankex.database.actions.AuthorizationActions;
import pl.projektowa.btcbankex.dbutils.DatabaseConnection;
import pl.projektowa.btcbankex.dbutils.TokenGenerator;
import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class AuthorizationActionsImpl implements AuthorizationActions {

	public boolean isTokenInDatabase(String token) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from TokenData where token=:n");
		query.setParameter("n", token);
		
		List<TokenData> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		TokenData td;
		try {
			td = list.get(0);
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public TokenData getTokenData(String token) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from TokenData where token=:n");
		query.setParameter("n", token);
		
		List<TokenData> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		TokenData td;
		try {
			td = list.get(0);			
			return td;
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
	}

	public TokenData getTokenData(int userId) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from User where user_id=:n");
		query.setParameter("n", userId);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);			
			return u.getAuth();
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
	}

}
