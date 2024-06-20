package com.fourmen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity 
public class Discount implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discountId;
	private int percentDiscount;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean status;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Discount(int discountId, int percentDiscount, String name, Date startDate, Date endDate, boolean status) {
		super();
		this.discountId = discountId;
		this.percentDiscount = percentDiscount;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Discount() {
		// TODO Auto-generated constructor stub
	}
	
}
