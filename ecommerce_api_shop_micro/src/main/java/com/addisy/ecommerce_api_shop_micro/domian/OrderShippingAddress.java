package com.addisy.ecommerce_api_shop_micro.domian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class OrderShippingAddress implements Serializable{

	private static final long serialVersionUID = 387419L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userShippingAddressId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserShippingAddressId() {
		return userShippingAddressId;
	}

	public void setUserShippingAddressId(Long userShippingAddressId) {
		this.userShippingAddressId = userShippingAddressId;
	}



}

