package pl.projektowa.btcbankex.database.models;

/**
 * Created by Kamil on 2016-11-01.
 */
public class BankTransfer {
    private String id;
    private String name;
    private String date;
    private String bankAccountIdFrom;
    private String getBankAccountIdTo;
    private double value;
    private CurrencyType currencyType;

    public BankTransfer(String id, String name, String date, String bankAccountIdFrom, String getBankAccountIdTo, double value, CurrencyType currencyType) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.bankAccountIdFrom = bankAccountIdFrom;
        this.getBankAccountIdTo = getBankAccountIdTo;
        this.value = value;
        this.currencyType = currencyType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBankAccountIdFrom() {
        return bankAccountIdFrom;
    }

    public void setBankAccountIdFrom(String bankAccountIdFrom) {
        this.bankAccountIdFrom = bankAccountIdFrom;
    }

    public String getGetBankAccountIdTo() {
        return getBankAccountIdTo;
    }

    public void setGetBankAccountIdTo(String getBankAccountIdTo) {
        this.getBankAccountIdTo = getBankAccountIdTo;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CurrencyType getCurrency() {
        return currencyType;
    }

    public void setCurrency(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
