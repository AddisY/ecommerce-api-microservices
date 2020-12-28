package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.security.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);

}
