package com.addisy.ecommerce_api_shop_micro.service.impl;

import com.addisy.ecommerce_api_shop_micro.domian.security.Role;
import com.addisy.ecommerce_api_shop_micro.repository.RoleRepository;
import com.addisy.ecommerce_api_shop_micro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findRoleByRoleName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}
