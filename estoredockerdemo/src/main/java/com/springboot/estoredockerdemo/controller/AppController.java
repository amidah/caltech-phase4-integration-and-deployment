package com.springboot.estoredockerdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.estoredockerdemo.model.Product;
import com.springboot.estoredockerdemo.model.Response;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/welcome")
	public String welcome() {
		return "<h3>Welcome to eStore</h3>";
	}
	
	@GetMapping("/products")
	public Response getProducts() {
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("iPhone", 70000));
		productList.add(new Product("MacBook", 170000));
		productList.add(new Product("Watch", 40000));
		
		Response response = new Response(101, "Products Fetched Successfully", productList);
		
		return response;
	}
}
