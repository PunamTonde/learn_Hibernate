package com.jbk.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {
		char ch;
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();
		Product product = null;

		do {
			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for getProductById ");
			System.out.println("Press 3 for delete product ");
			System.out.println("Press 4 for update product ");
			System.out.println("Press 5 for getallproduct ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				product = ProductUtility.prepareProductData(scanner);
				boolean isAdded = service.saveProduct(product);
				System.out.println(isAdded);
				if (isAdded) {
					System.out.println("Product saved");
				} else {
					System.out.println("Prouct Already Exists with Id" + product.getProductId());
					;
				}
				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				long Long = scanner.nextLong();
				long productId = Long;
				product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Product Not Exists !! ID=" + productId);
				}
				break;
			}

			case 3: {
				System.out.println("Enter Product Id");
				long productId = scanner.nextLong();
				boolean isDeleted = service.deleteProductById(productId);
				if (isDeleted) {
					System.out.println("Deleted");
				} else {
					System.out.println("Product Not Exists !!ID =" + productId);
				}

				break;
			}
			case 4: {
				product = ProductUtility.prepareProductData(scanner);
				boolean isUpdated = service.updateProduct(product);
				if (isUpdated) {
					System.out.println("Product is Updated");
				} else {
					System.out.println("product Not Updated");
				}
				break;
			}
			case 5: {
				List<Product> allProducts = service.getAllProducts();
				if (allProducts.isEmpty())  {
					System.out.println("Product Not EXists");
				} else {
					for (Product product1 : allProducts) {
						System.out.println(product);
					}
				}
				break;
			}

			default:
				break;

			}

			System.out.println("Do you want to continue y/n ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		System.out.println("terminated");

	}

}
