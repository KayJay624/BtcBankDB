package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.projektowa.btcbankex.actions.UserActionsImpl;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.User;

public class UserActionsTest {
	@Test
	public void isUserInDBTest() {
		boolean result = new UserActionsImpl().isUserInDatabase(35);
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void isUserInDBTestN() {
		boolean result = new UserActionsImpl().isUserInDatabase(1);
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void isUserInDB2Test() {
		boolean result = new UserActionsImpl().isUserInDatabase("user8", "passwd");
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void isUserInDB2TestN() {
		boolean result = new UserActionsImpl().isUserInDatabase("nimamniewbazie", "passwd");
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void getUserFromDBTest() {
		try {
			User u = new UserActionsImpl().getUserFromDatabase(42);
			u.print();				
		    assertEquals(u.getLogin(), "user8");
		
		} catch (Exception e) {			
			assert(false);
		}
	}
	
	@Test
	public void getUserFromDBTestN() {
		try {
			User u = new UserActionsImpl().getUserFromDatabase(0);							
		    assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
	
	@Test
	public void getUserFromDB2Test() {
		try {
			User u = new UserActionsImpl().getUserFromDatabase("user8", "passwd");
							
		    assertEquals(u.getLogin(), "user8");
		
		} catch (Exception e) {			
			assert(false);
		}
	}
	
	@Test
	public void getUserFromDB2TestN() {
		try {
			User u = new UserActionsImpl().getUserFromDatabase("user8", "zlehaslo");							
		    assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
	
	/*@Test
	public void addUserTest() {
		User u = new User("janektolol", "jan@test.pl", "passwd", "Jan", "Kłos");
		boolean result = new UserActionsImpl().addUserToDatabase(u);
				
		assertEquals(result, true);		
	}*/
	
	@Test
	public void addUserTestN() {
		User u = new User("tester3", "tester3@test.pl", "passwd", "Janusz", "Zbylut");
		boolean result = new UserActionsImpl().addUserToDatabase(u);
				
		assertEquals(result, false);		
	}
}
