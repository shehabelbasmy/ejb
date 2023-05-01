package tube.codingexamples.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="savingac")
public class SavingAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="person_name")
	private String name;
	@Column(name="balance")
	private int balance;

	public SavingAccount() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int withdraw(int credit) {
		balance=balance-credit;
		return balance;
	}
	
	public int deposite(int credit) {
		balance=balance+credit;
		return balance;
	}
   
}
