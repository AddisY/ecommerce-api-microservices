package com.addisy.ecommerce_api_shop_micro.controller;

import com.addisy.ecommerce_api_shop_micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public Map<String, String> token(HttpSession session, HttpServletRequest request) {

		Map<String, String> response = new HashMap<>();

		response.put("message", "Login Successful");
		response.put("sessionId", session.getId());

		return response;

	}


	@RequestMapping(value="/security/logout")
	public Map<String, String> logout(){
		SecurityContextHolder.clearContext();
		return Collections.singletonMap("message", "logout successful");
	}
}
