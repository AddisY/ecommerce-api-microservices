package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.security.Role;

public interface RoleService {

	Role findRoleByRoleName(String name);

	Role save(Role role);

}
