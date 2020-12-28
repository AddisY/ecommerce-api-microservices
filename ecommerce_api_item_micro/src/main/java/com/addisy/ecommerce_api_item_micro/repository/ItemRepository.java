package com.addisy.ecommerce_api_item_micro.repository;

import com.addisy.ecommerce_api_item_micro.domian.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
