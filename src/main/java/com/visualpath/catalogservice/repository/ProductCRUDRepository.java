package com.visualpath.catalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visualpath.catalogservice.product.Product;

public interface ProductCRUDRepository extends JpaRepository<Product,Long> {

	List<Product> findByName(String name);

}
