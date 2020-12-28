package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.User;
import com.addisy.ecommerce_api_shop_micro.domian.security.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);

	User findUserByUsername(String username);

	User findByEmail (String email);

	User save(User user);

	Optional<User> findById(Long id);

	void removeUserById(Long id);

	List<User> findAll();


}
