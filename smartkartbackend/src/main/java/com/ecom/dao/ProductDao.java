package com.ecom.dao;

import java.util.List;

import com.ecom.model.Category;
import com.ecom.model.Product;

public interface ProductDao
{
	public boolean add(Product product);
	public boolean delete(Product product);
	public boolean update(Product product);
	public List<Product> listProduct();
	public Product getProduct(int productId);
	 
}