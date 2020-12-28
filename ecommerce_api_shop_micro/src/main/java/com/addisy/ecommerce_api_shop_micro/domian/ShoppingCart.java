package com.addisy.ecommerce_api_shop_micro.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = -387148197L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal totalPrice;

	@OneToMany(mappedBy = "shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}

