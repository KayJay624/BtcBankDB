package pl.projektowa.btcbankex.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchase_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private Currency curr_to_buy;
	
	@ManyToOne
	//@JoinColumn(name = "code")
	private Currency curr_to_sell;
		
	private double amount;
	private double price;
	private Timestamp date;
	
	public Purchase() {
		
	}
	
	public Purchase(double amount, double price) {
		this.amount = amount;
		this.price = price;
		this.date = new Timestamp(new java.util.Date().getTime());
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Currency getCurr_to_buy() {
		return curr_to_buy;
	}

	public void setCurr_to_buy(Currency curr_to_buy) {
		this.curr_to_buy = curr_to_buy;
	}

	public Currency getCurr_to_sell() {
		return curr_to_sell;
	}

	public void setCurr_to_sell(Currency curr_to_sell) {
		this.curr_to_sell = curr_to_sell;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}
	
	public void print() {
		System.out.print(this.getUser_id().getLogin() + "\t");
		System.out.print(this.getCurr_to_buy().getCode() + "\t");
		System.out.print(this.getCurr_to_sell().getCode() + "\t");
		System.out.print(this.getAmount() + "\t");
		System.out.print(this.getPrice() + "\t");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss:SSS");
		System.out.println(dt.format(new Date(this.getDate().getTime())) + "\t");
	}
	
}
