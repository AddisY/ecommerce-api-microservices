package com.addisy.ecommerce_api_paymentCard_micro.service;

import com.addisy.ecommerce_api_paymentCard_micro.domian.UserShippingAddress;

import java.util.List;
import java.util.Optional;

public interface UserShippingAddressService {


	Optional<UserShippingAddress> findById(Long id);

	UserShippingAddress save(UserShippingAddress userShippingAddress);

	void removeById(Long id);

	List<UserShippingAddress> findAllByUserId(Long userId);

}
