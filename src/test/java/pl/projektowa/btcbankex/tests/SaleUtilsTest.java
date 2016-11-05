package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.PurchaseUtils;
import pl.projektowa.btcbankex.dbutils.SaleUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.Purchase;
import pl.projektowa.btcbankex.model.Sales;
import pl.projektowa.btcbankex.model.User;

public class SaleUtilsTest {
	@Test
	public void addSaleTest() {
		try {
			SaleUtils.addSale(35, "LTC", "PLN", 1.5, 1.45);
			
			User u = UsersUtils.getUserById(35);
			u.print();
			assertEquals(true, true);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	@Test
	public void getSaleTest() {
		try {			
			User u = UsersUtils.getUserById(35);
			Set<Sales> ss = u.getSales();
			
			for(Sales s : ss) {
				s.getDate();
			}
			
			u.print();
			assertEquals(true, true);
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
}
