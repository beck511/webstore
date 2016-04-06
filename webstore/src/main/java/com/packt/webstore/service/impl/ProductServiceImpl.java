package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.Product;
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
	public List<Product> getProductsByCategory(String category) {
		  return productRepository.getProductsByCategory(category);
		}
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
	    return productRepository.getProductsByFilter(filterParams);
	}
	public void addProduct(Product product) {
		   productRepository.addProduct(product);
		}
}
