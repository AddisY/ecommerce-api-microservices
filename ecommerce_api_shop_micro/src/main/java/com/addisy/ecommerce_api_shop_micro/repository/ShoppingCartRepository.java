package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

	ShoppingCart findByUser(User user);

}
