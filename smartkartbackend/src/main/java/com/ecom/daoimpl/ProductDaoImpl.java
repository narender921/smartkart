package com.ecom.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.dao.ProductDao;
import com.ecom.model.Category;
import com.ecom.model.Product;
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean add(Product product) {
		try {
			Session session = sessionFactory.openSession();
			session.save(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			Session session = sessionFactory.openSession();
			session.delete(product);
			return false;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Product product) {
		try {
			Session session = sessionFactory.openSession();
			session.update(product);
			return false;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> listProduct() {
		try {
			Session session = sessionFactory.openSession();
			
			List<Product> productList = (List<Product>) session.createQuery("from product").list();
			return productList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Product getProduct(int productId) {
		
		try {
			Session session = sessionFactory.openSession();
			
			Product product = (Product) session.createQuery("from Product where productId=:productId").setString("productId", "productId").uniqueResult();
			
			
			return product;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}