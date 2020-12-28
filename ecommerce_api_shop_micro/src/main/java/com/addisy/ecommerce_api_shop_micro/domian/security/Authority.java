package com.addisy.ecommerce_api_shop_micro.domian.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class Authority implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 145795L;

	private final String authority;

	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
