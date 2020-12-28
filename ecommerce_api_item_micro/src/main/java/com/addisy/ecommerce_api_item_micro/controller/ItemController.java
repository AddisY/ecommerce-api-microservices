package com.addisy.ecommerce_api_item_micro.controller;

import com.addisy.ecommerce_api_item_micro.domian.Category;
import com.addisy.ecommerce_api_item_micro.domian.Item;
import com.addisy.ecommerce_api_item_micro.service.CategoryService;
import com.addisy.ecommerce_api_item_micro.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping (value="/add", method= RequestMethod.POST)
	public Map<String,Object> addItemPost(@RequestBody Map<String, Object> mapper) {

		Item item = new Item();

		item.setName((String) mapper.get("name"));
		item.setPrice(Double.valueOf(String.valueOf(mapper.get("price"))));
		item.setWeight(Double.valueOf(String.valueOf(mapper.get("weight"))));
		item.setQntInStock((int) mapper.get("qntInStock"));
		item.setDescription((String) mapper.get("description"));

		Long categoryId = (Long.valueOf(String.valueOf(mapper.get("categoryId"))));
		Category category = categoryService.findCategoryById(categoryId).orElse(null);

		if(category==null){
			return Collections.singletonMap("message", "Category not found.");
		}

		item.setCategory(category);

		Item item1 = itemService.save(item);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Item added successfully");
		response.put("item", item1);

		return response;
	}

	@RequestMapping("/list")
	public List<Item> getItemList() {
		return itemService.findAll();
	}

	@RequestMapping("/{id}")
	public Optional<Item> getItem(@PathVariable("id") Long id){
		Optional<Item> item = itemService.findById(id);
		return item;
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Map<String, Object> updateItem(@RequestBody Item item) {

		Item item1 = itemService.save(item);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "update successful!");
		response.put("item", item1);

		return response;
	}

	@RequestMapping(value="/delete/{id}")
	public Map<String, String> delete(@PathVariable("id") Long id) {

		itemService.removeOne(id);

		return Collections.singletonMap("message", "item removed");
	}

}
