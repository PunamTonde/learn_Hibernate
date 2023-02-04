package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility {

	public static  Product prepareProductData(Scanner scanner) {
		System.out.println("Enter ProductId");
		long productid=scanner.nextLong();
		
		System.out.println("Enter Product Name");
		String productName =scanner.next();
		
		System.out.println("Enter CategorytId");
		long categorytId=scanner.nextLong();
		
		System.out.println("Enter  SupplierId");
		long supplierId  =scanner.nextLong();
		

		System.out.println("Enter Prouct QTY");
		int productQty =scanner.nextInt();
		
		System.out.println("Enter  Prouct Price");
		double productPrice =scanner.nextDouble();
		
		Product product = new Product(productid, productName, supplierId, categorytId, productQty, productPrice);
		
		return product;
	}
}
