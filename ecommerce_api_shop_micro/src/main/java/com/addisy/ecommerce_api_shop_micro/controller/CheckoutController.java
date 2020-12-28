package com.addisy.ecommerce_api_shop_micro.controller;

import com.addisy.ecommerce_api_shop_micro.domian.*;
import com.addisy.ecommerce_api_shop_micro.service.OrderService;
import com.addisy.ecommerce_api_shop_micro.service.ShoppingCartService;
import com.addisy.ecommerce_api_shop_micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CheckoutController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/checkout", method=RequestMethod.POST)
	public Map<String,Object> checkout(@RequestBody HashMap<String, Object> mapper, Principal principal){

			String userShippingAddressId = String.valueOf(mapper.get("userShippingAddressId"));

		UserShippingAddress userShippingAddress = restTemplate.getForObject("http://localhost:8082/userShippingAddress/"+userShippingAddressId, UserShippingAddress.class);

		String paymentCardId = String.valueOf(mapper.get("paymentCardId"));

		PaymentCard paymentCard = restTemplate.getForObject("http://localhost:8082/paymentCard/"+paymentCardId, PaymentCard.class);

		if (userShippingAddress==null){
			return Collections.singletonMap("message", "Shipping address not found");
		}

		if (paymentCard==null){
			return Collections.singletonMap("message", "Payment card not found");
		}

		ShoppingCart shoppingCart = userService.findUserByUsername(principal.getName()).getShoppingCart();
		User user = userService.findUserByUsername(principal.getName());
		Order order = orderService.createOrder(shoppingCart, userShippingAddress, paymentCard, user);

		shoppingCartService.clearShoppingCart(shoppingCart);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Checkout successful!!!");
		response.put("order", order);

		return response;

	}

}

