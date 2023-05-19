package com.devsuperior.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.searchAll(pageable);
	}
}
