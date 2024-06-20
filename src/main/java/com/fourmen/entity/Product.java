package com.fourmen.entity;

import java.io.Serializable;
import java.util.List;

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
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(columnDefinition = "NVARCHAR(200)  NULL")
	private String productCode;
	@Column(columnDefinition = "NVARCHAR(30)  NULL")
	private String name;
	@Column(columnDefinition = "NVARCHAR(4000) NULL")
	private String description;
	private boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ImageProduct> images;
	
	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;
	
	
	
	public Product(int productId, String productCode, String name, String description, boolean status,
			List<ImageProduct> images, Brand brand) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.name = name;
		this.description = description;
		this.status = status;
		this.images = images;
		this.brand = brand;
	}

	

	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public List<ImageProduct> getImages() {
		return images;
	}


	public void setImages(List<ImageProduct> images) {
		this.images = images;
	}


	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}


	public Brand getBrand() {
		return brand;
	}




	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
