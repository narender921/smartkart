package com.ecom.daotest;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ecom.dao.ProductDao;
import com.ecom.model.Product;



public class ProductDaoTest 
{
	
	static ProductDao productDao;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecom");
		context.refresh();
		
		productDao=(ProductDao)context.getBean("productDao");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("WindowCurtain and BedSheet");
		product.setProductQuantity(("It's depend on the product"));
		
		assertTrue("Problem in Adding the Product",productDao.add(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{	
		Product product=productDao.getProduct(2);
		product.setProductQuantity("It's depend on the product");
		assertTrue("Problem in Updating the Category",productDao.update(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDao.getProduct(2);
		assertTrue("Problem in Updating the Category",productDao.delete(product));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Product> listCategories=productDao.listProduct();
		
		assertTrue("Problem in Listing the Categories",listCategories.size()>0);
		
		for(Product product:listCategories)
		{
			System.out.print("Product ID:"+product.getProductId());
			System.out.print("Product Name:"+product.getProductName());
			System.out.println("Product Price:"+product.getProductPrice());
		}
	}
	
}