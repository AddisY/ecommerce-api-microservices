package com.addisy.ecommerce_api_item_micro.service;

import com.addisy.ecommerce_api_item_micro.domian.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

	List<Item> findAll();

	Optional<Item> findById(Long id);

	Item save(Item item);

	void removeOne(Long id);
}
