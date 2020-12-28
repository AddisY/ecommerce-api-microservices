package com.addisy.ecommerce_api_paymentCard_micro.domian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserShippingAddress {
	private static final long serialVersionUID = 2354344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userShippingAddressName;
	private String userShippingAddressStreet;
	private String userShippingAddressCity;
	private String userShippingAddressState;
	private String userShippingAddressCountry;
	private String userShippingAddressZipcode;
	private Long userId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserShippingAddressName() {
		return userShippingAddressName;
	}

	public void setUserShippingAddressName(String userShippingAddressName) {
		this.userShippingAddressName = userShippingAddressName;
	}

	public String getUserShippingAddressStreet() {
		return userShippingAddressStreet;
	}

	public void setUserShippingAddressStreet(String userShippingAddressStreet) {
		this.userShippingAddressStreet = userShippingAddressStreet;
	}

	public String getUserShippingAddressCity() {
		return userShippingAddressCity;
	}

	public void setUserShippingAddressCity(String userShippingAddressCity) {
		this.userShippingAddressCity = userShippingAddressCity;
	}

	public String getUserShippingAddressState() {
		return userShippingAddressState;
	}

	public void setUserShippingAddressState(String userShippingAddressState) {
		this.userShippingAddressState = userShippingAddressState;
	}

	public String getUserShippingAddressCountry() {
		return userShippingAddressCountry;
	}

	public void setUserShippingAddressCountry(String userShippingAddressCountry) {
		this.userShippingAddressCountry = userShippingAddressCountry;
	}

	public String getUserShippingAddressZipcode() {
		return userShippingAddressZipcode;
	}

	public void setUserShippingAddressZipcode(String userShippingAddressZipcode) {
		this.userShippingAddressZipcode = userShippingAddressZipcode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
