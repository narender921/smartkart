package com.ecom.daotest;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.SupplierDao;
import com.ecom.model.Supplier;



public class SupplierDaoTest 
{
	
	static SupplierDao supplierDao;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecom");
		context.refresh();
		
		supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("ABC");
		supplier.setSupplierAddress("...");
		
		assertTrue("Problem in Adding the Supplier",supplierDao.add(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{	
		Supplier supplier=supplierDao.getSupplier(2);
		supplier.setSupplierAddress("...");	
		assertTrue("Problem in Updating the Supplier",supplierDao.update(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplier(2);
		assertTrue("Problem in Updating the Supplier",supplierDao.delete(supplier));
	}
	
	@Test
	public void listSupplierTest()
	{
		List<Supplier> listSupplier=supplierDao.listSupplier();
		
		assertTrue("Problem in Listing the Supplier",listSupplier.size()>0);
		
		for(Supplier supplier:listSupplier)
		{
			System.out.print("Supplier ID:"+supplier.getSupplierId());
			System.out.print("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Address:"+supplier.getSupplierAddress());
			System.out.println("Supplier ContactDetail:"+supplier.getSupplierContactDetail());
		}
	}
	
}