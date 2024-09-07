package com.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.entites.Product;

@Service
public class ProductServicesImpl implements ProductServices {

	private final String API_URL = "https://fakestoreapi.com/products";

	private final RestTemplate restTemplate;

	@Autowired
	public ProductServicesImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> findProductsByCategory(String category) {

		String getUrl = API_URL + "/category/" + category;

		Product[] products = restTemplate.getForObject(getUrl, Product[].class);
		
		return Arrays.asList(products);
	}

	@Override
	public Product createProduct(Product product) {

		Product savedProd = restTemplate.postForObject(API_URL, product, Product.class);

		return savedProd;
	}

}
