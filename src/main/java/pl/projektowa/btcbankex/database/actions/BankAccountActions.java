package pl.projektowa.btcbankex.database.actions;


import java.util.List;

import pl.projektowa.btcbankex.model.BankAccount;

/**
 * Created by Kamil on 2016-11-01.
 */
public interface BankAccountActions {
    boolean isBankAccountInDatabase(int id);

    boolean addBankAccountToDatabase(int userId, String code, String addr, double balance);

    BankAccount getBankAccount(int id) throws Exception;
    List<BankAccount> getAllBankAccountsOfUser(int userId);

    // changeToBalance can be either a positive or a negative number, to add to or subtract from account balance
    boolean changeBalance(int id, Double changeToBalance);

    boolean deleteBankAccount(int id);
}
