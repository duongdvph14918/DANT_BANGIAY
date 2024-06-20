package com.fourmen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
public class Orders implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(columnDefinition = "NVARCHAR(200) Not NULL")
	private String address;
	
	private Date createDate = new Date();
	
	@Column(columnDefinition = "NVARCHAR(15)  NULL")
	private String sdtNn;
	
	@Column(columnDefinition = "NVARCHAR(50) Not NULL")
	private int status;
	
	@Column(columnDefinition = "NVARCHAR(200)  NULL")
	private String tenNn;
	
	private double total;
	
	
	@Column(columnDefinition="int default 0")
	private int paymentStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Accounts account;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "voucherId")
	private Vouchers voucher;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTenNn() {
		return tenNn;
	}

	public void setTenNn(String tenNn) {
		this.tenNn = tenNn;
	}

	public String getSdtNn() {
		return sdtNn;
	}

	public void setSdtNn(String sdtNn) {
		this.sdtNn = sdtNn;
	}
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public Vouchers getVoucher() {
		return voucher;
	}

	public void setVoucher(Vouchers voucher) {
		this.voucher = voucher;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public Orders(int orderId, String address, Date createDate, String sdtNn, int status, String tenNn, double total,
			int paymentStatus, Accounts account, Vouchers voucher, List<OrderDetail> orderDetails) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.createDate = createDate;
		this.sdtNn = sdtNn;
		this.status = status;
		this.tenNn = tenNn;
		this.total = total;
		this.paymentStatus = paymentStatus;
		this.account = account;
		this.voucher = voucher;
		this.orderDetails = orderDetails;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
