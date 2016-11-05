package pl.projektowa.btcbankex.database.actions;

import pl.projektowa.btcbankex.model.BankTransfer;

import java.util.List;

/**
 * Created by Kamil on 2016-11-01.
 */
public interface BankTransferActions {
    boolean isBankTransferInDatabase(int id);

    boolean addBankTransferToDatabase(String name, int fromId, int toId, double amount);

    BankTransfer getBankTransfer(int id) throws Exception;
    List<BankTransfer> getBankTransfersMadeToAccount(int bankAccountId);
    List<BankTransfer> getBankTransfersMadeFromAccount(int bankAccountId);

    boolean deleteBankTransferFromDatabase(String id);
}
