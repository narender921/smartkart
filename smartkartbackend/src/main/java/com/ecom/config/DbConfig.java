package com.ecom.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.Supplier;
import com.ecom.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecom")
public class DbConfig 
{
	
	//1. We need to create a Data Source
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/smartkart");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("---DataSource Object is Created----");
		return dataSource;
	}
	
	//2. We need to Create LocalSessionFactoryBuilder object which is used to get SessionFactory object
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProp);
		factory.addAnnotatedClass(Product.class);

		factory.addAnnotatedClass(Category.class);

		factory.addAnnotatedClass(User.class);

		factory.addAnnotatedClass(Supplier.class);
		
		//factory.scanPackages("com.niit");
		System.out.println("---SessionFactory Object  Created ----");
		
		return factory.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager object Created--");
		return new HibernateTransactionManager(sessionFactory);
	}
	}


