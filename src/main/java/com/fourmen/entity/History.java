package com.fourmen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class History implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int payId;
	private int bankId;
	@Column(columnDefinition = "NVARCHAR(30) NULL")
	private String namebank;
	private int orderId;
	private Date datePay;
	@Column(columnDefinition = "NVARCHAR(30) NULL")
	private String shoeTypePay;
	private float totalPay;
	public History() {
		
	}
	public History(int payId, int bankId, String namebank, int orderId, Date datePay, String shoeTypePay,
			float totalPay) {
		super();
		this.payId = payId;
		this.bankId = bankId;
		this.namebank = namebank;
		this.orderId = orderId;
		this.datePay = datePay;
		this.shoeTypePay = shoeTypePay;
		this.totalPay = totalPay;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getNamebank() {
		return namebank;
	}
	public void setNamebank(String namebank) {
		this.namebank = namebank;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDatePay() {
		return datePay;
	}
	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}
	public String getShoeTypePay() {
		return shoeTypePay;
	}
	public void setShoeTypePay(String shoeTypePay) {
		this.shoeTypePay = shoeTypePay;
	}
	public float getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(float totalPay) {
		this.totalPay = totalPay;
	}
	
	
	
}
