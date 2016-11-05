package pl.projektowa.btcbankex.model;

import java.util.Set;

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
@Table(name = "address")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addr_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private Currency code;
		
	private String addr;
	private double balance;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="from_addr")
	private Set<BankTransfer> fromTransactions;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="to_addr")
	private Set<BankTransfer> toTransactions;
	
	public BankAccount() {
		
	}
	
	public BankAccount(String addr, double balance) {
		this.addr = addr;
		this.balance = balance;
	}

	public int getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Currency getCode() {
		return code;
	}

	public void setCode(Currency code) {
		this.code = code;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Set<BankTransfer> getFromTransactions() {
		return fromTransactions;
	}

	public void setFromTransactions(Set<BankTransfer> fromTransactions) {
		this.fromTransactions = fromTransactions;
	}

	public Set<BankTransfer> getToTransactions() {
		return toTransactions;
	}

	public void setToTransactions(Set<BankTransfer> toTransactions) {
		this.toTransactions = toTransactions;
	}

	public void print() {
		System.out.print(this.getUser_id().getLogin() + "\t");
		System.out.print(this.getCode().getCode() + "\t");
		System.out.print(this.getAddr() + "\t");
		System.out.println(this.getBalance() + "\t");
	}
	
}
