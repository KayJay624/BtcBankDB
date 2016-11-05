package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.User;

public class AddressUtilsTest {
	@Test
	public void addAddressTest() {
		try {
			AddressUtils.addAddress(35, "BTC", "12235f23242fd323432", 0.023345);
			
			User u = UsersUtils.getUserById(35);
			u.print();
			
			for (Iterator<BankAccount> it = u.getAddresses().iterator(); it.hasNext(); ) {
		        BankAccount a = it.next();
		        if (a.getAddr().equals("12235f23242f323432")){
		        	assert(true);
		        	return;
		        }
		    }
			assert(false);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
		@Test
		public void getAllAddressesTest() {
			try {
				List<BankAccount> al = AddressUtils.getAllAddresses();
				
				for(BankAccount a : al){
					a.print();
				}
				
				assertEquals(true, true);
							
			} catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
	}
}
