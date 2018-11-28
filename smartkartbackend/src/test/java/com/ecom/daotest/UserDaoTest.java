package com.ecom.daotest;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.UserDao;
import com.ecom.model.User;



public class UserDaoTest 
{
	
	static UserDao userDao;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecom");
		context.refresh();
		
		userDao=(UserDao)context.getBean("userDao");
	}
	
	@Ignore
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setContact("9999999999");
		user.setUserEmailId("abc@gmail.com");
		user.setUserAddress("Delhi");
		user.setUserName("Abc");
		user.setUserPassword("********");
		
		
		
		assertTrue("Problem in Adding the User",userDao.add(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{	
		User user=userDao.getUser(2);
		user.setContact("");
		user.setUserAddress("");	
		assertTrue("Problem in Updating the User",userDao.update(user));
	}
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=userDao.getUser(2);
		assertTrue("Problem in Updating the User",userDao.delete(user));
	}
	
	@Test
	public void listUserTest()
	{
		List<User> listUser=userDao.listUser();
		
		assertTrue("Problem in Listing the User",listUser.size()>0);
		
		for(User user:listUser)
		{
			System.out.print("User EmailId:"+user.getUserEmailId());
			System.out.print("User Password:"+user.getUserPassword());
			System.out.print("User Name:"+user.getUserName());
			System.out.print("User Contact:"+user.getContact());
			System.out.println("User Address:"+user.getUserAddress());
		}
	}
	
}