package com.ecom.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.dao.CategoryDao;
import com.ecom.model.Category;



@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean add(Category category) {

			
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(category);
			System.out.println("addCategory");
			
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			System.out.println("Catch");
			return false;
		}
	}

	public boolean delete(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.delete(category);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.update(category);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> listCategories() {
		try {
			Session session = sessionFactory.openSession();
			
			List<Category> categoryList = (List<Category>) session.createQuery("from Category").list();
			
			
			
			return categoryList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Category getCategory(int categoryId) {
		try {
			Session session = sessionFactory.openSession();
			
			Category category = (Category) session.createQuery("from Category where categoryId=:categoryId").setString("categoryId", "categoryId").uniqueResult();
			
			
			return category;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}


	
	
	
