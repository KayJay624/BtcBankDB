package pl.projektowa.btcbankex.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.CurrencyUtils;
import pl.projektowa.btcbankex.model.Currency;

public class CurrencyUtilsTest {
	@Test
	public void getCurrencyByCodeTest() {
		try {
			Currency c = CurrencyUtils.getCurrencyByCode("BTC");
			c.print();
			
	    	assertEquals(c.getName(), "BitCoin");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}		
	}
	
	@Test
	public void getCurrencyByCodeWrongTest() {
		try {
			Currency c = CurrencyUtils.getCurrencyByCode("JPG");
			c.print();
			
	    	assertEquals(c.getName(), "BitCoin");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}		
	}

}
