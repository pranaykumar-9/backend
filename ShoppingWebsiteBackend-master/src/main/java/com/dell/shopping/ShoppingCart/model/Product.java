package com.dell.shopping.ShoppingCart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="product_id")
	private long productId;
	@Column(name="product_name")
	private String productName;

	@Column(name = "price")
	private double price;
	
	@Column(name = "date_added")
	private Date dateAdded;  

	@ManyToOne()
	@JoinColumn(name = "productgroup_id")
	private ProductGroup productgrp;
	
	public Product() 
	{
		
	}

	public Product(long productId, String productName, double price, Date dateAdded, ProductGroup productgrp) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.dateAdded = dateAdded;
		this.productgrp = productgrp;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public ProductGroup getProductgrp() {
		return productgrp;
	}

	public void setProductgrp(ProductGroup productgrp) {
		this.productgrp = productgrp;
	}

	 

	
}
