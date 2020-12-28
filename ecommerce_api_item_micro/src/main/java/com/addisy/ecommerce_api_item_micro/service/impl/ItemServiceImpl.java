package com.addisy.ecommerce_api_item_micro.service.impl;

import com.addisy.ecommerce_api_item_micro.domian.Item;
import com.addisy.ecommerce_api_item_micro.repository.ItemRepository;
import com.addisy.ecommerce_api_item_micro.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAll() {
		List<Item> itemList = (List<Item>) itemRepository.findAll();

		return itemList;

	}

	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public void removeOne(Long id) {
		itemRepository.deleteById(id);
	}

}
