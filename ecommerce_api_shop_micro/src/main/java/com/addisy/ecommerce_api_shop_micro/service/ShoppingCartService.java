package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import com.addisy.ecommerce_api_shop_micro.domian.User;

public interface ShoppingCartService {

	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	void clearShoppingCart(ShoppingCart shoppingCart);

	ShoppingCart findByUser(User user);

}
