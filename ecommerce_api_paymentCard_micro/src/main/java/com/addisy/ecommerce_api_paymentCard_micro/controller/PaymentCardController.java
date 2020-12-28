package com.addisy.ecommerce_api_paymentCard_micro.controller;

import com.addisy.ecommerce_api_paymentCard_micro.domian.PaymentCard;
import com.addisy.ecommerce_api_paymentCard_micro.service.PaymentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paymentCard")
public class PaymentCardController {

	@Autowired
	private PaymentCardService paymentCardService;


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map<String, Object> addNewPaymentCard(
			@RequestBody HashMap<String, Object> mapper
	) {

		String userId = String.valueOf(mapper.get("userId"));


		PaymentCard paymentCard = new PaymentCard();
		paymentCard.setUserId(Long.valueOf(userId));
		paymentCard.setHolderName((String) mapper.get("holderName"));
		paymentCard.setCardName((String) mapper.get("cardName"));
		paymentCard.setCardNumber((String) mapper.get("cardNumber"));

		PaymentCard paymentCard1 = paymentCardService.save(paymentCard);

		Map<String, Object> response = new HashMap<>();

		response.put("message", "Added successfully!");
		response.put("paymentCard", paymentCard1);

		return response;
	}

	@RequestMapping(value = "/{id}")
	public PaymentCard getPaymentCard(
			@PathVariable("id") Long id
	) {
		return paymentCardService.findById(id).orElse(null);
	}

	@RequestMapping(value = "/delete/{id}")
	public Map<String, String> removePaymentCard(
			@PathVariable("id") Long id
	) {

		paymentCardService.removeById(id);

		return Collections.singletonMap("message", "Payment card removed");
	}

	@RequestMapping("/list/{userId}")
	public List<PaymentCard> getPaymentCardList(
			@PathVariable("userId") Long userId
	) {

		List<PaymentCard> paymentCardList = paymentCardService.findAllByUserId(userId);

		return paymentCardList;
	}

}

