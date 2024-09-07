package com.demo.service;

import java.util.List;

import com.demo.entites.Product;

public interface ProductServices {

	public List<Product> findProductsByCategory(String category);

	public Product createProduct(Product product);
}
