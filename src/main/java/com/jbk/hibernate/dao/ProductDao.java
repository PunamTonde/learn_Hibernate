package com.jbk.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		try {

			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return true;
	}

	public Product getProductById(long productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return product;

	}

	public boolean deleteProductById(long productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product product = new Product();
			product.setProductId(productId);
			session.delete(product);
			transaction.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			
			transaction.commit();
			isUpdated= true;
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null ;
	try {
	Criteria criteria =	session.createCriteria(Product.class);
     list =	criteria.list();
     
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
	
	
		return list;
	}

	
	
}
