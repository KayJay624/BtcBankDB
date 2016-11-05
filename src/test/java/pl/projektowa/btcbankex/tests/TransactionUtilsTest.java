package pl.projektowa.btcbankex.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import pl.projektowa.btcbankex.dbutils.AddressUtils;
import pl.projektowa.btcbankex.dbutils.TransactionUtils;
import pl.projektowa.btcbankex.dbutils.UsersUtils;
import pl.projektowa.btcbankex.model.BankAccount;
import pl.projektowa.btcbankex.model.BankTransfer;
import pl.projektowa.btcbankex.model.User;

public class TransactionUtilsTest {
	@Test
	public void addTransactionTest() {
		try {
			TransactionUtils.addTransaction("testTrans1", 14, 12, 0.005345);
						
			User u = UsersUtils.getUserById(35);
			Set<BankAccount> la = u.getAddresses();
			
			for(BankAccount a : la) {
				System.out.println("Transactions FROM this account :" + a.getAddr());
				for(BankTransfer t : a.getFromTransactions()) {
					t.print();
				}
			}
			
			for(BankAccount a : la) {
				System.out.println("Transactions TO this account :" + a.getAddr());
				for(BankTransfer t : a.getToTransactions()) {
					t.print();
				}
			}
			
			for(BankTransfer t : AddressUtils.getAddressesById(14).getFromTransactions()) {				
				if(t.getName().equals("testTrans1")) {
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
	public void getTransactionTest() {
		try {							
			User u = UsersUtils.getUserById(35);
			Set<BankAccount> la = u.getAddresses();
			
			for(BankAccount a : la) {
				System.out.println("Transactions FROM " + a.getAddr() + " account :" );
				for(BankTransfer t : a.getFromTransactions()) {
					t.print();
				}
			}
			
			for(BankAccount a : la) {
				System.out.println("Transactions TO " + a.getAddr() + " account :" );
				for(BankTransfer t : a.getToTransactions()) {
					t.print();
				}
			}
			
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
}
