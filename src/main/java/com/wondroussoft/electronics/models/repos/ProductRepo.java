package com.wondroussoft.electronics.models.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondroussoft.electronics.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoryId(Long categoryId);

	Optional<Product> findById(Long id);
}

