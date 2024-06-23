package com.fourmen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Vouchers implements Serializable{
	
	@Id
	@Column(length = 50, nullable = false,columnDefinition = "NVARCHAR(30)")
	private String voucherId;
	private double conditions;
	private Date startDate;
	private Date endDate;
	
	@Column(columnDefinition = "NVARCHAR(255) NULL")
	private String note;
	private int quantity;
	private boolean status;
	private double valued;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "voucher")
	@JsonIgnore
	private List<Orders> orders;

	

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public double getValued() {
		return valued;
	}

	public void setValued(double valued) {
		this.valued = valued;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getConditions() {
		return conditions;
	}

	public void setConditions(double conditions) {
		this.conditions = conditions;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Vouchers(String voucherId, double conditions, Date startDate, Date endDate, String note, int quantity,
			boolean status, double valued, String name, List<Orders> orders) {
		super();
		this.voucherId = voucherId;
		this.conditions = conditions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.note = note;
		this.quantity = quantity;
		this.status = status;
		this.valued = valued;
		this.name = name;
		this.orders = orders;
	}

	public Vouchers() {
		// TODO Auto-generated constructor stub
	}
	
	
}
