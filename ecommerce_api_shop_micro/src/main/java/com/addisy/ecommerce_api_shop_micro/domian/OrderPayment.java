package com.addisy.ecommerce_api_shop_micro.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderPayment implements Serializable{
	private static final long serialVersionUID = 79151235145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private Long paymentCardId;

	@OneToOne(mappedBy = "orderPayment")
	@JsonIgnore
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getPaymentCardId() {
		return paymentCardId;
	}

	public void setPaymentCardId(Long paymentCardId) {
		this.paymentCardId = paymentCardId;
	}
}

