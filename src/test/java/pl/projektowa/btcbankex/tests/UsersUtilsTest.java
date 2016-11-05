package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.DatabaseConnection;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.User;

public class UsersUtilsTest {

	@Test
	public void getAllUsersTest() {
		List<User> ul = UsersUtils.getAllUsers();
		
		for(User u : ul) {
			u.print();
		}
    	
    	assertEquals(ul, ul);
	}
	
	@Test
	public void getUserByIdTest() {
		try {
			User u = UsersUtils.getUserById(35);
			u.print();
			
	    	assertEquals(u.getLogin(), "user8");
		} catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void getUserByFakeIdTest() {
		try {
			User u = UsersUtils.getUserById(0);
			u.print();
					
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals(true, true);
		}
	}
	
	@Test
	public void getUserByLoginTest() {
		try {
			User u = UsersUtils.getUserByLogin("user8");
			u.print();
			
	    	assertEquals(u.getUser_id(), 35);
		} catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void getUserByFakeLoginTest() {
		try {
			User u = UsersUtils.getUserByLogin("niemamniewbazie");
			u.print();
					
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals(true, true);
		}		
	}
	
	@Test
	public void addUserTest() {
		try {
			User u = new User("janektolol", "jan@test.pl", "passwd", "Jan", "Kłos");
			UsersUtils.addUser(u);
			
			UsersUtils.getUserByLogin("tester").print();
			
			assertEquals(UsersUtils.getUserByLogin("janektolol").getLogin(), "janektolol");
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void loginTest() {
		try {			
			String token = UsersUtils.login("user8", "passwd");						
			assertEquals(token, "ilqri8rhp6thk3gbrs8hgpbnsg" );
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}		
	}
	
	@Test
	public void loginWrongTest() {
		try {			
			String token = UsersUtils.login("nimamniewbazie", "haselko");						
			assertEquals(token, true);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}		
	}
}
