package com.wondroussoft.electronics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wondroussoft.electronics.models.Category;
import com.wondroussoft.electronics.models.Product;
import com.wondroussoft.electronics.models.repos.ProductRepo;
import com.wondroussoft.electronics.models.services.CategoryService;

@RestController
public class ElectronicsController {

	@Autowired
	CategoryService serviceCategory;

	@Autowired
	ProductRepo repoProduct;

	@GetMapping("/categories")
	public ResponseEntity<Object> getElectronicsCategories() {

		List<Category> categories = serviceCategory.getAllCategories();

		return new ResponseEntity<>(categories, HttpStatus.OK);

	}

	@GetMapping("/products/category/{categoryId}")
	public ResponseEntity<Object> getProducts(@PathVariable(name = "categoryId") Long categoryId) {

		List<Product> products = repoProduct.findByCategoryId(categoryId);

		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	@PostMapping("/category/add")
	public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
		// Save new category
		serviceCategory.saveCategory(category);

		List<Category> categories = serviceCategory.getAllCategories();

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping("/product/add/category/{categoryId}")
	public ResponseEntity<Object> saveProduct(@PathVariable(name = "categoryId") Long categoryId,
			@RequestBody Product product) {
		// Save new product
		product.setCategoryId(categoryId);
		repoProduct.save(product);
		
		List<Product> products = repoProduct.findByCategoryId(categoryId);

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{productId}/details")
	public ResponseEntity<Object> getProduct(@PathVariable(name = "productId") Long productId) {

		try {
			Product product = repoProduct.findById(productId).get();
			
			if(product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		} catch (Exception e) {
			// do nothing
		}
		return new ResponseEntity<>("Product with product id as " + productId + " not found", HttpStatus.OK);

	}
}
