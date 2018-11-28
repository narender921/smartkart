package com.ecom.daotest;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.CategoryDao;
import com.ecom.model.Category;



public class CategoryDaoTest 
{
	@Autowired
	static CategoryDao categoryDao;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecom");
		context.refresh();
		
		categoryDao=(CategoryDao)context.getBean("categoryDao");
	}
	
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("BedSheets");
		category.setCategoryDesc("Various Variety of BedSheets");
		
		assertTrue("Problem in Adding the Category",categoryDao.add(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{	
		Category category=categoryDao.getCategory(2);
		category.setCategoryDesc("Curtain and Bedsheet ");	
		assertTrue("Problem in Updating the Category",categoryDao.update(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategory(2);
		assertTrue("Problem in Updating the Category",categoryDao.delete(category));
	}
	
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDao.listCategories();
		
		assertTrue("Problem in Listing the Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print("Category ID:"+category.getCategoryId());
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());
		}
	}
	
}