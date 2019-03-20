package com.visualpath.catalogservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visualpath.catalogservice.product.Product;
import com.visualpath.catalogservice.repository.ProductCRUDRepository;



@Service("ProdcutService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	 ProductCRUDRepository productCRUDRepository;

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return productCRUDRepository.findById(id).get();
	}

	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return productCRUDRepository.findByName(name);
	}

	@Override
	public ResponseEntity<String> createProduct(Product product) {
		// TODO Auto-generated method stub
		Product savedProduct=productCRUDRepository.save(product);
		if(savedProduct!=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}

	@Override
	public ResponseEntity<Object> updateProductByID(Product product, long id) {
		// TODO Auto-generated method stub
		Optional<Product> product1=productCRUDRepository.findById(id);
		if(product1.isPresent())
		{
			product.setId(id);
			productCRUDRepository.save(product);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public void deleteProductById(long id) {
		// TODO Auto-generated method stub
		productCRUDRepository.deleteById(id);
	}
}

/*
 * @Override public List<User> getUserByName(String name) { // TODO
 * Auto-generated method stub //return userCRUDRepository.findByName(name);
 * return userCRUDRepository.findByName(name); }
 */

/*
 * @Override public User findById(Long id) { // TODO Auto-generated method stub
 * return userCRUDRepository.findById(id).get(); }
 */