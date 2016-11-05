package pl.projektowa.btcbankex.database.models;

/**
 * Created by Kamil on 2016-11-01.
 */
public class BankAccount {
    private String id;
    private String userId;
    private CurrencyType currencyType;
    private String accountNumber;
    private Double balance;

    public BankAccount(String id, String userId, CurrencyType currencyType, String accountNumber, Double balance) {
        this.id = id;
        this.userId = userId;
        this.currencyType = currencyType;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
