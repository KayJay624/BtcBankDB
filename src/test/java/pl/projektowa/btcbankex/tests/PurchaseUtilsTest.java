package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.PurchaseUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.Purchase;
import pl.projektowa.btcbankex.model.User;

public class PurchaseUtilsTest {
	@Test
	public void addPurchaseTest() {
		try {
			PurchaseUtils.addPurchase(35, "LTC", "PLN", 1.5, 1.45);
			
			User u = UsersUtils.getUserById(35);
			u.print();
			assertEquals(true, true);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	@Test
	public void getPurchaseTest() {
		try {			
			User u = UsersUtils.getUserById(35);
			Set<Purchase> ps = u.getPurchases();
			
			for(Purchase p : ps) {
				p.getDate();
			}
			
			u.print();
			assertEquals(true, true);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
}
