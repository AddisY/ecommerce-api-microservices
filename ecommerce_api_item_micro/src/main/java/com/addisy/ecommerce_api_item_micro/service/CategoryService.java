package com.addisy.ecommerce_api_item_micro.service;

import com.addisy.ecommerce_api_item_micro.domian.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

	Category save(Category category);

	Optional<Category> findCategoryById(Long id);

	void deleteCategoryById(Long id);

	List<Category> findAll();
}
