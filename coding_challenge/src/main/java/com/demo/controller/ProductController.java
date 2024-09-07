package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entites.Product;
import com.demo.service.ProductServices;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductServices productServices;

	@Autowired
	public ProductController(ProductServices productServices) {
		super();
		this.productServices = productServices;
	}

	@GetMapping("byCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {

		List<Product> products = productServices.findProductsByCategory(category);

		return ResponseEntity.ok(products);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		Product savedProd = productServices.createProduct(product);

		return ResponseEntity.ok(savedProd);
	}

}
