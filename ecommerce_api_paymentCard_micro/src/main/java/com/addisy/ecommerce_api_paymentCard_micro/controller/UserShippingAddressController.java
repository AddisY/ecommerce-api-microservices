package com.addisy.ecommerce_api_paymentCard_micro.controller;


import com.addisy.ecommerce_api_paymentCard_micro.domian.UserShippingAddress;
import com.addisy.ecommerce_api_paymentCard_micro.service.UserShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userShippingAddress")
public class UserShippingAddressController {

	@Autowired
	private UserShippingAddressService userShippingAddressService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map<String, Object> addNewUserShippingAddress(
			@RequestBody HashMap<String, Object> mapper
	) {

		String userId = String.valueOf(mapper.get("userId"));

		UserShippingAddress userShippingAddress = new UserShippingAddress();
		userShippingAddress.setUserId(Long.valueOf(userId));
		userShippingAddress.setUserShippingAddressName((String) mapper.get("userShippingAddressName"));
		userShippingAddress.setUserShippingAddressStreet((String) mapper.get("userShippingAddressStreet"));
		userShippingAddress.setUserShippingAddressCity((String) mapper.get("userShippingAddressCity"));
		userShippingAddress.setUserShippingAddressState((String) mapper.get("userShippingAddressState"));
		userShippingAddress.setUserShippingAddressCountry((String) mapper.get("userShippingAddressCountry"));
		userShippingAddress.setUserShippingAddressZipcode((String) mapper.get("userShippingAddressZipcode"));

		UserShippingAddress userShippingAddress1 = userShippingAddressService.save(userShippingAddress);

		Map<String, Object> response = new HashMap<>();

		response.put("message", "Added successfully!");
		response.put("userSippingAddress", userShippingAddress1);

		return response;
	}

	@RequestMapping(value = "/{id}")
	public UserShippingAddress getUserShippingAddress(
			@PathVariable("id") Long id
	) {
		return userShippingAddressService.findById(id).orElse(null);
	}

	@RequestMapping("/list/{id}")
	public List<UserShippingAddress> getUserShippingAddressList(@PathVariable("id") Long id) {

		return userShippingAddressService.findAllByUserId(id);

	}

	@RequestMapping(value = "/delete/{id}")
	public Map<String, String> removeUserShippingAddress(
			@PathVariable("id") Long id
	) {
		userShippingAddressService.removeById(id);
		return Collections.singletonMap("message", "Shipping address removed");
	}

}

