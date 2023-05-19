package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories")
	List<Product> searchAll();
	
	@Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories",
			countQuery = "SELECT COUNT(obj) FROM Product obj JOIN obj.categories")
	Page<Product> searchAll(Pageable pageable);
}
