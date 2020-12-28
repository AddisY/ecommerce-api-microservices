package com.addisy.ecommerce_api_shop_micro.service.impl;

import com.addisy.ecommerce_api_shop_micro.domian.CartItem;
import com.addisy.ecommerce_api_shop_micro.domian.Item;
import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import com.addisy.ecommerce_api_shop_micro.repository.ShoppingCartRepository;
import com.addisy.ecommerce_api_shop_micro.service.CartItemService;
import com.addisy.ecommerce_api_shop_micro.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private RestTemplate restTemplate;

	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal totalPrice = new BigDecimal(0);

		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {

			Item item = restTemplate.getForObject("http://localhost:8083/item/"+cartItem.getItemId(), Item.class);

			if(item.getQntInStock()>0) {
				cartItemService.updateCartItem(cartItem);
				totalPrice = totalPrice.add(cartItem.getSubtotal());
			}
		}

		shoppingCart.setTotalPrice(totalPrice);

		shoppingCartRepository.save(shoppingCart);

		return shoppingCart;
	}

	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for(CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}

		shoppingCart.setTotalPrice(new BigDecimal(0));

		shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public ShoppingCart findByUser(User user) {
		return shoppingCartRepository.findByUser(user);
	}
}
