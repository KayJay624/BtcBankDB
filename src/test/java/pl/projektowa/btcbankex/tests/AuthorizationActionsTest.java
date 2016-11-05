package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.projektowa.btcbankex.actions.AuthorizationActionsImpl;
import pl.projektowa.btcbankex.actions.UserActionsImpl;
import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class AuthorizationActionsTest {
	@Test
	public void isTokenInDBTest() {
		boolean result = new AuthorizationActionsImpl().isTokenInDatabase("ilqri8rhp6thk3gbrs8hgpbnsg");
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void isTokenInDBTestN() {
		boolean result = new AuthorizationActionsImpl().isTokenInDatabase("sialala");
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void getTokenTest() {
		try {
			TokenData td = new AuthorizationActionsImpl().getTokenData(35);
							
		    assertEquals(td.getToken(), "ilqri8rhp6thk3gbrs8hgpbnsg");
		
		} catch (Exception e) {			
			assert(false);
		}
	}
	
	@Test
	public void getTokenTestN() {
		try {
			TokenData td = new AuthorizationActionsImpl().getTokenData(0);							
		    assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
	
	@Test
	public void getToken2Test() {
		try {
			TokenData td = new AuthorizationActionsImpl().getTokenData("ilqri8rhp6thk3gbrs8hgpbnsg");
							
		    assertEquals(td.getUser_id().getLogin(), "user8");
		
		} catch (Exception e) {			
			assert(false);
		}
	}
	
	@Test
	public void getToken2TestN() {
		try {
			TokenData td = new AuthorizationActionsImpl().getTokenData("eloelo320");							
		    assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
}
