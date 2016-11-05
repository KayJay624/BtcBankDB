package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import pl.projektowa.btcbankex.actions.BankAccountActionsImpl;
import pl.projektowa.btcbankex.actions.BankTransferActionsImpl;
import pl.projektowa.btcbankex.actions.UserActionsImpl;
import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.TransactionUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.BankTransfer;
import pl.projektowa.btcbankex.model.User;

public class BankTransferActionsTest {
	@Test
	public void isTransInDBTest() {
		boolean result = new BankTransferActionsImpl().isBankTransferInDatabase(1);
						
	    assertEquals(result, true);	
	}
	
	@Test
	public void isTransInDBTestN() {
		boolean result = new BankTransferActionsImpl().isBankTransferInDatabase(0);
						
	    assertEquals(result, false);	
	}
	
	@Test
	public void addTransactionTest() {
		boolean result = new BankTransferActionsImpl().addBankTransferToDatabase("testTrans1", 14, 12, 0.015345);
					
		assertEquals(result, true);						
	}
	
	@Test
	public void addTransactionTestN() {
		boolean result = new BankTransferActionsImpl().addBankTransferToDatabase("testTrans1", 14, 0, 0.015345);
					
		assertEquals(result, false);						
	}
	
	@Test
	public void getTransToTest() {
		List<BankTransfer> result = new BankTransferActionsImpl().getBankTransfersMadeToAccount(14);
		
		for(BankTransfer b : result) {
			b.print();
		}
		
	    assert(true);	
	}
	
	@Test
	public void getTransFromTest() {
		List<BankTransfer> result = new BankTransferActionsImpl().getBankTransfersMadeFromAccount(14);
		
		for(BankTransfer b : result) {
			b.print();
		}
		
	    assert(true);	
	}

	
	@Test
	public void getBankAccountTest() {
		try {
			BankTransfer td = new BankTransferActionsImpl().getBankTransfer(1);									    
			assertEquals(td.getName(), "testTrans1");
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(false);
		}	
	}
	
	@Test
	public void getBankAccountTestN() {
		try {
			BankTransfer td = new BankTransferActionsImpl().getBankTransfer(0);									    
			assert(false);
		
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			assert(true);
		}	
	}
}
