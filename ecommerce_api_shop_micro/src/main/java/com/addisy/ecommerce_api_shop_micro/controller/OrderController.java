package com.addisy.ecommerce_api_shop_micro.controller;

import com.addisy.ecommerce_api_shop_micro.domian.Order;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import com.addisy.ecommerce_api_shop_micro.service.CartItemService;
import com.addisy.ecommerce_api_shop_micro.service.OrderService;
import com.addisy.ecommerce_api_shop_micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/{id}")
	public Optional<Order> getOrder(@PathVariable("id") Long id) {

		return orderService.findOrderById(id);
	}

	@RequestMapping("/getOrderHistory")
	public List<Order> getOrderHistory(Principal principal) {

		User user = userService.findUserByUsername(principal.getName());
		List<Order> orderList = user.getOrderList();

		return orderList;
	}

}

