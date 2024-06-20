package com.fourmen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;	
	@Column(columnDefinition = "NVARCHAR(255) NULL")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Accounts account;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	

	public Address(int addressId, String name, Accounts account) {
		super();
		this.addressId = addressId;
		this.name = name;
		this.account = account;
	}



	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Accounts getAccount() {
		return account;
	}


	public void setAccount(Accounts account) {
		this.account = account;
	}
	
	

}
