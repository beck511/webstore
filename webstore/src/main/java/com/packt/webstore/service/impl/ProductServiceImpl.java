package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts(){
		return productRepository.getAllProducts();
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
	public Product getProductsById(String productId){
		return productRepository.getProductById(productId);
	}


	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

}
