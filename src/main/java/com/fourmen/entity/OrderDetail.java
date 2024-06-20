package com.fourmen.entity;

import java.io.Serializable;

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
public class OrderDetail implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	private  int quantity;
	private double price;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "productDetailId")
	private ProductDetail productDetail;
	
	public OrderDetail(int orderDetailId, int quantity, double price, boolean status, Orders order,
			ProductDetail productDetail) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.order = order;
		this.productDetail = productDetail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
}
