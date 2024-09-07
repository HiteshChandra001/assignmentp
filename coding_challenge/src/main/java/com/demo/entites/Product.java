package com.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
	private int id;
	private double price;
	private String title, description, category, image;
	private Rating rating;
	
}
