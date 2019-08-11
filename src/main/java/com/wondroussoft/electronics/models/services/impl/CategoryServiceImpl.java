package com.wondroussoft.electronics.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondroussoft.electronics.models.Category;
import com.wondroussoft.electronics.models.repos.CategoryRepo;
import com.wondroussoft.electronics.models.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo repoCategory;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return repoCategory.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		repoCategory.save(category);

	}

}
