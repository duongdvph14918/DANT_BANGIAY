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
public class ProductDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productDetailId;
	
	
	@Column(columnDefinition = "NVARCHAR(30)  NULL")
	private String name;
	@Column(columnDefinition = "NVARCHAR(4000) NULL")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "shoeTypeId")
	private ShoeType shoeType;
	
	@ManyToOne
	@JoinColumn(name = "sizeId")
	private Size size;
	
	@ManyToOne
	@JoinColumn(name = "styleId")
	private Style style;
	
	@ManyToOne
	@JoinColumn(name = "shoeSoleId")
	private ShoeSole shoeSole;
	
	@ManyToOne
	@JoinColumn(name = "colorId")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Material material;
	
	@ManyToOne
	@JoinColumn(name = "discountId")
	private Discount discount;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	private int quantity;
	
	private double price;
	
	private boolean status;
	


	public ProductDetail(int productDetailId, String name, String description, ShoeType shoeType, Size size,
			Style style, ShoeSole shoeSole, Color color, Material material, Discount discount, Product product,
			int quantity, double price, boolean status) {
		super();
		this.productDetailId = productDetailId;
		this.name = name;
		this.description = description;
		this.shoeType = shoeType;
		this.size = size;
		this.style = style;
		this.shoeSole = shoeSole;
		this.color = color;
		this.material = material;
		this.discount = discount;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	public int getProductDetailId() {
		return productDetailId;
	}
	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}
	public ShoeType getShoeType() {
		return shoeType;
	}
	public void setShoeType(ShoeType shoeType) {
		this.shoeType = shoeType;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public ShoeSole getShoeSole() {
		return shoeSole;
	}
	public void setShoeSole(ShoeSole shoeSole) {
		this.shoeSole = shoeSole;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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




	public Size getSize() {
		return size;
	}




	public void setSize(Size size) {
		this.size = size;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}


	public ProductDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
