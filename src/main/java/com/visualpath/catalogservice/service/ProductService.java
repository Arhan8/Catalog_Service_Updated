package com.visualpath.catalogservice.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.visualpath.catalogservice.product.Product;

public interface ProductService {

Product findById(long id);

List<Product> getProductByName(String name);

ResponseEntity<String> createProduct(Product product);

ResponseEntity<Object> updateProductByID(Product product, long id);

void deleteProductById(long id);





}
