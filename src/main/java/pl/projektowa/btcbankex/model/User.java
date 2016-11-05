/**
 * 
 */
package pl.projektowa.btcbankex.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.projektowa.btcbankex.dbutils.TokenGenerator;

/**
 * @author Kamil Jurek
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	private String email;
	private String passwd;
	private String login;
	private String name;
	private String lastname;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy="user_id")
	private TokenData auth;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user_id")
	private Set<BankAccount> addresses;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user_id")
	private Set<Purchase> purchases;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user_id")
	private Set<Sales> sales;
	
	public User() {
		
	}
	
	public User(String login, String email, String passwd, String name, String lastname) {
		this.email = email;
		this.passwd = passwd;
		this.login = login;
		this.name = name;
		this.lastname = lastname;		
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
		
	public Set<BankAccount> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<BankAccount> addresses) {
		this.addresses = addresses;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}
		
	public TokenData getAuth() {
		return auth;
	}

	public void setAuth(TokenData auth) {
		this.auth = auth;
	}
		
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	public void print() {
		System.out.print(this.getUser_id() + "\t");
		System.out.print(this.getLogin() + "\t");
		System.out.print(this.getEmail() + "\t");
		System.out.print(this.getName() + "\t");
		System.out.print(this.getLastname() + "\t");
		System.out.println(this.getPasswd() + "\t");
		
		System.out.println("ADDRESSES:");
		if(addresses != null) {
			for(BankAccount a : addresses) {
				a.print();
			}
		}
		
		System.out.println("PURCHASES:");
		if(purchases != null) {
			for(Purchase p : purchases) {
				p.print();
			}
		}
		
		System.out.println("SALES:");
		if(sales != null) {
			for(Sales s : sales) {
				s.print();
			}
		}
		
		System.out.println("TOKEN: " + this.getAuth().getToken());
	}

	
}
