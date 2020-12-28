package com.addisy.ecommerce_api_paymentCard_micro.repository;

import com.addisy.ecommerce_api_paymentCard_micro.domian.PaymentCard;
import org.springframework.data.repository.CrudRepository;

public interface PaymentCardRepository extends CrudRepository<PaymentCard, Long> {

	Iterable<PaymentCard> findAllByUserId(Long userId);
}
