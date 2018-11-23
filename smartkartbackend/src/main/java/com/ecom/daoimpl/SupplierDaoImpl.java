package com.ecom.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.dao.SupplierDao;
import com.ecom.model.Category;
import com.ecom.model.Supplier;

public class SupplierDaoImpl implements SupplierDao {
          
	
	@Autowired	
        SessionFactory sessionFactory;
    	@Transactional
	public boolean add(Supplier supplier) {
    		try {
    			Session session = sessionFactory.openSession();
    			session.save(supplier);
    			return true;
    		} catch (HibernateException e) {
    			
    			e.printStackTrace();
    			return false;
    		}

	}

	public boolean delete(Supplier subpplier) {
		try {
			Session session = sessionFactory.openSession();
			session.delete(subpplier);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier subpplier) {
		try {
			Session session = sessionFactory.openSession();
			session.update(subpplier);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public List<Supplier> listSupplier() {
		try {
			Session session = sessionFactory.openSession();
			
			List<Supplier> supplierList = (List<Supplier>) session.createQuery("from Supplier").list();
			
			
			
			return supplierList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Supplier getSupplier(int subpplierId) {
		try {
			Session session = sessionFactory.openSession();
			
			Supplier supplier = (Supplier) session.createQuery("from Supplier where supplierId=:supplierId").setString("supplierId", "supplierId").uniqueResult();
			
			
			return supplier;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
