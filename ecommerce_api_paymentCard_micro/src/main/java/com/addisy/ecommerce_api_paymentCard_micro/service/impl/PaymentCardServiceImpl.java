package com.addisy.ecommerce_api_paymentCard_micro.service.impl;

import com.addisy.ecommerce_api_paymentCard_micro.domian.PaymentCard;
import com.addisy.ecommerce_api_paymentCard_micro.repository.PaymentCardRepository;
import com.addisy.ecommerce_api_paymentCard_micro.service.PaymentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentCardServiceImpl implements PaymentCardService {
	@Autowired
	private PaymentCardRepository paymentCardRepository;

	public PaymentCard save(PaymentCard paymentCard) {
		return paymentCardRepository.save(paymentCard);
	}

	@Override
	public List<PaymentCard> findAllByUserId(Long userId) {
		return (List<PaymentCard>) paymentCardRepository.findAllByUserId(userId);
	}

	public Optional<PaymentCard> findById(Long id) {

		return paymentCardRepository.findById(id);
	}

	public void removeById(Long id) {
		paymentCardRepository.deleteById(id);
	}


}
