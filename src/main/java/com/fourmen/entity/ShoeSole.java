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
public class ShoeSole implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int shoeSoleId;
	@Column(columnDefinition = "NVARCHAR(255)  NULL")
	String name;
	private boolean status;
	
	public int getShoeSoleId() {
		return shoeSoleId;
	}
	public void setShoeSoleId(int shoeSoleId) {
		this.shoeSoleId = shoeSoleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public ShoeSole(int shoeSoleId, String name, boolean status) {
		super();
		this.shoeSoleId = shoeSoleId;
		this.name = name;
		this.status = status;
	}
	public ShoeSole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
