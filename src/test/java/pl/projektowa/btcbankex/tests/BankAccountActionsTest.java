package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import pl.projektowa.btcbankex.actions.AuthorizationActionsImpl;
import pl.projektowa.btcbankex.actions.BankAccountActionsImpl;
import pl.projektowa.btcbankex.actions.UserActionsImpl;
import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.TokenData;
import pl.projektowa.btcbankex.model.User;

public class BankAccountActionsTest {
	@Test
	public void isAccountInDBTest() {
		boolean result = new BankAccountActionsImpl().isBankAccountInDatabase(14);
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void isAccountInDBTestN() {
		boolean result = new UserActionsImpl().isUserInDatabase(0);
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void changeBalanceTest() {
		boolean result = new BankAccountActionsImpl().changeBalance(14, 10.0);
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void changeBalance2Test() {
		boolean result = new BankAccountActionsImpl().changeBalance(14, -10.0);
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void changeBalanceTestN() {
		boolean result = new BankAccountActionsImpl().changeBalance(0, -12.0);
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void getAllAccountsTest() {
		List<BankAccount> result = new BankAccountActionsImpl().getAllBankAccountsOfUser(35);
		
		for(BankAccount b : result) {
			b.print();
		}
		
	    assert(true);	
	}
	
	@Test
	public void getBankAccountTest() {
		try {
			BankAccount td = new BankAccountActionsImpl().getBankAccount(14);
							
		    assertEquals(td.getAddr(), "12235f23242fd323432");
		
		} catch (Exception e) {			
			assert(false);
		}
	}
	
	@Test
	public void getBankAccountTestN() {
		try {
			BankAccount td = new BankAccountActionsImpl().getBankAccount(0);							
		    assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
	
	@Test
	public void addBankAccountTest() {
		boolean result = new BankAccountActionsImpl().addBankAccountToDatabase(42, "BTC", "myvcP1FEBugsAL2BLzNNFwuYi53rG1whso", 0.0);
		
		assertEquals(result, true);
						
	}
	
	@Test
	public void addBankAccountTestN() {

		boolean result = new BankAccountActionsImpl().addBankAccountToDatabase(35, "BTC", "12235f23242fdgsd", 0.05555);
		
		assertEquals(result, false);
						
	}
	
	@Test
	public void removeBankAccountTestN() {
		boolean result = new BankAccountActionsImpl().deleteBankAccount(0);
		
		assertEquals(result, false);
						
	}
	
	/*@Test
	public void removeBankAccountTest() {
		boolean result = new BankAccountActionsImpl().deleteBankAccount(12);
		
		assertEquals(result, false);
						
	}*/
}
