package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.CartItem;
import com.addisy.ecommerce_api_shop_micro.domian.Item;
import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import com.addisy.ecommerce_api_shop_micro.domian.User;

import java.util.List;
import java.util.Optional;

public interface CartItemService {

	// Converts an Item in to a CartItem that is to be added to a ShoppingCart
	CartItem convertItemToCartItem(Item item, User user, int quantity);

	List<CartItem> findCartItemsByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);

	Optional<CartItem> findById(Long id);

	CartItem save(CartItem cartItem);
}
