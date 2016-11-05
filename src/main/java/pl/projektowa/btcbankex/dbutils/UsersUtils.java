package pl.projektowa.btcbankex.dbutils;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class UsersUtils {
	
	public static List<User> getAllUsers() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Users");
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	public static User getUserById(int id) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Users where id=:n");
		query.setParameter("n", id);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
		
		
		return u;
	}
	
	public static User getUserByLogin(String login) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Users where login=:n");
		query.setParameter("n", login);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("User does not exist");
		}
		
		
		return u;
	}
	
	public static boolean addUser(User user) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	   	
		try {	
			
			session.save(user);			
			
			TokenData t = new TokenData(user, new TokenGenerator().getToken());
			user.setAuth(t);
			
			session.save(t);
			session.getTransaction().commit();
			
			session.close();
			
			return true;
		} catch (Exception e) {
			throw new Exception("User with this login or email exists");
		}		
	}
	
	public static String login(String login, String passwd) throws Exception{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
    	
    	Session session = dbc.getSession();
    	session.beginTransaction();
    	   	
    	Query query = session.createQuery("from Users where login=:l and passwd=:p");
		query.setParameter("l", login);
		query.setParameter("p", passwd);
		
		List<User> list = query.list();
	   	
    	session.getTransaction().commit();
		session.close();
				
		User u;
		try {
			u = list.get(0);
			
			return u.getAuth().getToken();
		
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Incorrect login or password");
		}		
	}
}
