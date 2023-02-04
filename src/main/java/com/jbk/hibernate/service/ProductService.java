package com.jbk.hibernate.service;

import java.util.List;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {
	ProductDao dao =new ProductDao();
	Product product =null;

	public boolean saveProduct(Product product) {
		dao.saveProduct(product);
		return false;
	}

	public Product getProductById(long productId) {
		dao.getProductById(productId);
		return product;
	}

	public boolean deleteProductById(long productId) {
	    boolean isDeleted = dao.deleteProductById(productId);
	    return isDeleted;
	}

	public boolean updateProduct(Product product) {
	boolean isUpdated =dao.updateProduct(product);
		return isUpdated;
	}

	public  List<Product>  getAllProducts() {
		return dao.getAllProducts();
	}

	
	
}
