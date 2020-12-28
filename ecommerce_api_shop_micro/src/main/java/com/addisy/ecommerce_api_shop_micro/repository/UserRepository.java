package com.addisy.ecommerce_api_shop_micro.repository;

import com.addisy.ecommerce_api_shop_micro.domian.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();

}
