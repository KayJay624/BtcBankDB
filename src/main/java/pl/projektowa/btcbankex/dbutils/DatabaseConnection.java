package pl.projektowa.btcbankex.dbutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class DatabaseConnection {
	private final String psqlServerName ="jdbc:postgresql://planer.cukg4kbdopna.us-west-2.rds.amazonaws.com:5432/postgres";
	private final String psqlUserName = "kamil";
	private final String psqlUserPassword = "kamil12345";
	    
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	private static class DatabaseConnectionLoader {
		private static final DatabaseConnection INSTANCE = new DatabaseConnection();
	}
	    
	private DatabaseConnection() {
		if (DatabaseConnectionLoader.INSTANCE != null) {
	    	throw new IllegalStateException("DatabaseConnection object already instantiated!");
	    
		} else {
	        	sessionFactory = createSessionFactory();
	        	
	        	System.out.println("Connected to PSQL successfully");            
	        }
	    }
	    
	    public Session getSession() {    	
	    	return sessionFactory.openSession();
	    }
	    
	    public static DatabaseConnection getInstance() {
	        return DatabaseConnectionLoader.INSTANCE;
	    }
	    
	   
	    
	    public static SessionFactory createSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        serviceRegistry = new ServiceRegistryBuilder().applySettings(
	                configuration.getProperties()). buildServiceRegistry();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        return sessionFactory;
	    }
	
}
