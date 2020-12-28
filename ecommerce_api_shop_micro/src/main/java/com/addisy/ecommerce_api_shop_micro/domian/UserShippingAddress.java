package com.addisy.ecommerce_api_shop_micro.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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


	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;


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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
