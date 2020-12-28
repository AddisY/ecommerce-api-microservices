package com.addisy.ecommerce_api_paymentCard_micro.service;

import com.addisy.ecommerce_api_paymentCard_micro.domian.PaymentCard;

import java.util.List;
import java.util.Optional;

public interface PaymentCardService {

	Optional<PaymentCard> findById(Long id);

	void removeById(Long id);

	PaymentCard save(PaymentCard paymentCard);

	List<PaymentCard> findAllByUserId(Long userId);
}
