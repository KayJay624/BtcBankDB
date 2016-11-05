package pl.projektowa.btcbankex.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class TokenData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int auth_id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user_id;
	
	private String token;
	private Timestamp date;
	
	public TokenData() {
		
	}
	
	public TokenData(User user, String token) {
		this.token = token;
		this.user_id = user;
		this.date = new Timestamp(new java.util.Date().getTime());
	}

	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
