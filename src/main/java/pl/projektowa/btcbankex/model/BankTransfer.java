package pl.projektowa.btcbankex.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class BankTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	
	private String name;
	private Timestamp date;
	
	@ManyToOne
	@JoinColumn(name = "from_addr")
	private BankAccount from_addr;
	
	@ManyToOne
	@JoinColumn(name = "to_addr")
	private BankAccount to_addr;
	
	private double amount;
	
	public BankTransfer() {
		
	}
	
	public BankTransfer(String name, double amount) {
		this.name = name;
		this.amount = amount;
		this.date = new Timestamp(new java.util.Date().getTime());
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BankAccount getFrom_addr() {
		return from_addr;
	}

	public void setFrom_addr(BankAccount from_addr) {
		this.from_addr = from_addr;
	}

	public BankAccount getTo_addr() {
		return to_addr;
	}

	public void setTo_addr(BankAccount to_addr) {
		this.to_addr = to_addr;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void print() {
		System.out.print(this.getName() + "\t");
		System.out.print(this.getAmount() + "\t");
		System.out.print(this.getFrom_addr().getUser_id().getLogin() + "\t");
		System.out.print(this.getTo_addr().getUser_id().getLogin() + "\t");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss:SSS");
		System.out.println(dt.format(new Date(this.getDate().getTime())) + "\t");
	}
}
