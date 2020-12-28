package com.addisy.ecommerce_api_paymentCard_micro.repository;

import com.addisy.ecommerce_api_paymentCard_micro.domian.UserShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserShippingAddressRepository extends CrudRepository<UserShippingAddress, Long> {

	Iterable<UserShippingAddress> findAllByUserId(Long userId);
}
