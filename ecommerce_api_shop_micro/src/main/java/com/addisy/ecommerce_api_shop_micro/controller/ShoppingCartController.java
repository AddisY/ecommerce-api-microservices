package com.addisy.ecommerce_api_shop_micro.controller;

import com.addisy.ecommerce_api_shop_micro.domian.CartItem;
import com.addisy.ecommerce_api_shop_micro.domian.Item;
import com.addisy.ecommerce_api_shop_micro.domian.ShoppingCart;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import com.addisy.ecommerce_api_shop_micro.service.CartItemService;
import com.addisy.ecommerce_api_shop_micro.service.ShoppingCartService;
import com.addisy.ecommerce_api_shop_micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value="/addItem", method= RequestMethod.POST)
	public Map<String,Object> addCartItem (@RequestBody HashMap<String, String> mapper, Principal principal ){

		String itemId = (String) mapper.get("itemId");
		String quantity = (String) mapper.get("quantity");

		User user = userService.findUserByUsername(principal.getName());
		Item item = restTemplate.getForObject("http://localhost:8083/item/"+itemId, Item.class);
		ShoppingCart shoppingCart = shoppingCartService.findByUser(user);

		if (item == null){
			return Collections.singletonMap("message", "Item doesn't exist");
		}

		if(Integer.parseInt(quantity) > item.getQntInStock()) {
			return Collections.singletonMap("message", "Not enough quantity in stock.");
		}

		CartItem cartItem = cartItemService.convertItemToCartItem(item, user, Integer.parseInt(quantity));

		ShoppingCart shoppingCart1 = shoppingCartService.updateShoppingCart(shoppingCart);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Item added to cart!");
		response.put("shoppingCart", shoppingCart1);

		return response;

	}

	@RequestMapping("/removeItem/{id}")
	public Map<String,String> removeCartItem(@PathVariable("id") String id) {

		CartItem cartItem = cartItemService.findById(Long.parseLong(id)).orElse(null);

		if (cartItem == null){
			return Collections.singletonMap("message", "Item doesn't exist");
		}

		cartItemService.removeCartItem(cartItem);

		return Collections.singletonMap("message", "Item removed from cart");
	}

	@RequestMapping(value="/updateItem", method= RequestMethod.POST)
	public Map<String,Object> updateCartItem(
			@RequestBody HashMap<String, String> mapper
	){
		String cartItemId = mapper.get("cartItemId");
		String quantity = mapper.get("quantity");

		CartItem cartItem = cartItemService.findById(Long.parseLong(cartItemId)).orElse(null);

		if (cartItem == null){
			return Collections.singletonMap("message", "Item doesn't exist");
		}

		cartItem.setQuantity(Integer.parseInt(quantity));

		CartItem cartItem1 = cartItemService.updateCartItem(cartItem);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Cart item updated!");
		response.put("cartItem", cartItem1);

		return response;
	}

	@RequestMapping("/getItemList")
	public List<CartItem> getCartItemList(Principal principal) {

		User user = userService.findUserByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		return cartItemList;
	}

	@RequestMapping("/getShoppingCart")
	public ShoppingCart getShoppingCart(Principal principal) {
		User user = userService.findUserByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		shoppingCartService.updateShoppingCart(shoppingCart);

		return shoppingCart;
	}


}
