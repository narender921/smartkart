 
package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product
{
	@Id
	 
	int productId;
	String productName;
	String productQuantity;
	
	public int getProductId() 
	{
		return productId;
	}
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public String getProductPrice() 
	{
		return productQuantity;
	}
	public void setproductPrice(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
} 