package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.CartItem;
import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	List<CartItem> findCartItemsByShoppingCart(ShoppingCart shoppingCart);

}
