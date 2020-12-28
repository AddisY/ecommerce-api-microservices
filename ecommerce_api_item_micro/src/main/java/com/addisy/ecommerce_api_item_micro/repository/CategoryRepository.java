package com.addisy.ecommerce_api_item_micro.repository;

import com.addisy.ecommerce_api_item_micro.domian.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
