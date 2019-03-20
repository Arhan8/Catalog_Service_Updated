package com.visualpath.catalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visualpath.catalogservice.product.Product;
import com.visualpath.catalogservice.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	ProductService prodService;
	
	/*
	 * @RequestMapping(value = "/user/{id}", method =RequestMethod.GET ) public User
	 * getUserByID(@PathVariable("id") long id) { return userService.findById(id); }
	 */

	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public Product getProductByID(@PathVariable("id") long id) {
	return prodService.findById(id);
	}
	
	 @RequestMapping(value = "/productByName/{name}", method =RequestMethod.GET )
	 public List<Product> getProductByName(@PathVariable("name") String name) {
	return prodService.getProductByName(name);
		
	 }
	 @RequestMapping(value="/newProduct",method=RequestMethod.POST)
	  public ResponseEntity<String> createProduct(@RequestBody Product product){
		return prodService.createProduct(product);
	}
	  
	  @RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	  public ResponseEntity<Object> updateProductByID(@RequestBody Product product,@PathVariable("id") long id){
		return prodService.updateProductByID(product,id);
	}
	  
	  @RequestMapping(value = "/product/{id}", method =RequestMethod.DELETE )
		 public void deleteProductByID(@PathVariable("id") long id) {
		  prodService.deleteProductById(id);
		 } 

}
