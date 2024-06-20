package com.fourmen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
public class ShoeType implements Serializable{
	//loại giày
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoeTypeId;
	@Column(columnDefinition = "NVARCHAR(255) NULL")
	private String name;
	private boolean status;
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public int getShoeTypeId() {
		return shoeTypeId;
	}

	public void setShoeTypeId(int shoeTypeId) {
		this.shoeTypeId = shoeTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	public ShoeType(int shoeTypeId, String name, boolean status) {
		super();
		this.shoeTypeId = shoeTypeId;
		this.name = name;
		this.status = status;
	}

	public ShoeType() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
