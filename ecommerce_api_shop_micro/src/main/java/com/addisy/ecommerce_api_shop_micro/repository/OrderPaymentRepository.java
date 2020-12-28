package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.OrderPayment;
import org.springframework.data.repository.CrudRepository;

public interface OrderPaymentRepository extends CrudRepository<OrderPayment, Long> {
}
