package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.*;

import java.util.Optional;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, UserShippingAddress userShippingAddress, PaymentCard paymentCard, User user
	);

	Order saveOrder(Order order);
	Optional<Order> findOrderById(Long id);
}
