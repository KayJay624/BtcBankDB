package pl.projektowa.btcbankex.actions;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.projektowa.btcbankex.database.actions.UserActions;
import pl.projektowa.btcbankex.dbutils.DatabaseConnection;
import pl.projektowa.btcbankex.dbutils.TokenGenerator;
import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class UserActionsImpl implements UserActions {

	public boolean isUserInDatabase(int id) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from User where user_id=:n");
		query.setParameter("n", id);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean isUserInDatabase(String login, String password) {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from User where login=:l and passwd=:p");
		query.setParameter("l", login);
		query.setParameter("p", password);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
			return true;
		
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean addUserToDatabase(User user) {
		DatabaseConnection dbc = DatabaseConnection.getInstance();  	
    	Session session = dbc.getSession();
    	Transaction tx = session.beginTransaction();    	   	
		
    	try {				
			session.save(user);			
			
			TokenData t = new TokenData(user, new TokenGenerator().getToken());
			user.setAuth(t);
			
			session.save(t);
			session.getTransaction().commit();
			
			session.close();
			
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		}		
	}

	public User getUserFromDatabase(int userId) throws Exception {
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
			return u;
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
	}

	public User getUserFromDatabase(String login, String password) throws Exception {
		DatabaseConnection dbc = DatabaseConnection.getInstance(); 	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from User where login=:l and passwd=:p");
		query.setParameter("l", login);
		query.setParameter("p", password);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
			return u;
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
	}

}
