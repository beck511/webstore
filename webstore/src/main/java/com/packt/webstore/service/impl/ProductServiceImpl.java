package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.repository.ProductRepository;

public class ProductServiceImpl {
	@Autowired
	private ProductRepository productRepository;

	public ProductRepository getAllProducts(){
		return productRepository;
	}
	
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
