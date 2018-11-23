package com.ecom.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.dao.UserDao;
import com.ecom.model.Category;
import com.ecom.model.User;
 


public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean add(User user) {
		
		try {
			Session session = sessionFactory.openSession();
			session.save(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	
	}

	public boolean delete(User userId) {
		try {
			Session session = sessionFactory.openSession();
			session.delete(userId);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User userId) {
		try {
			Session session = sessionFactory.openSession();
			session.update(userId);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public List<User> listUser() {
		try {
			Session session = sessionFactory.openSession();
			
			List<User> userList = (List<User>) session.createQuery("from Category").list();
			
			
			
			return null;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public User getUser(int userId) {
		try {
			Session session = sessionFactory.openSession();
			
			User user = (User) session.createQuery("from User where userId=:userId").setString("userId", "userId").uniqueResult();
			
			
			return user;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	
}