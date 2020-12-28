package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.Order;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findByUser(User user);
}
