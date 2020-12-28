package com.addisy.ecommerce_api_shop_micro;

import com.addisy.ecommerce_api_shop_micro.config.SecurityUtility;
import com.addisy.ecommerce_api_shop_micro.domian.User;
import com.addisy.ecommerce_api_shop_micro.domian.security.Role;
import com.addisy.ecommerce_api_shop_micro.domian.security.UserRole;
import com.addisy.ecommerce_api_shop_micro.service.RoleService;
import com.addisy.ecommerce_api_shop_micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EcommerceApiApplication implements CommandLineRunner {


	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApiApplication.class, args);
	}

	@Override
	public void run(String... args) {

		/*

		Register the user roles (i.e. ROLE_USER and ROLE_ADMIN), an Admin, and a test user when the application starts for the first time.

		 ***/

		Role role1 = new Role();
		role1.setName("ROLE_USER");
		Role userRole = new Role();
		if(roleService.findRoleByRoleName("ROLE_USER") == null){
			userRole = roleService.save(role1);
		}

		Role role2 = new Role();
		role2.setName("ROLE_ADMIN");
		Role adminRole = new Role();
		if(roleService.findRoleByRoleName("ROLE_ADMIN") == null){
			adminRole = roleService.save(role2);
		}

		User testUser = new User();
		testUser.setFirstName("testUser");
		testUser.setLastName("test_user");
		testUser.setUsername("testUser");
		testUser.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		testUser.setEmail("testUser@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role testUserRole = new Role();
		testUserRole.setRoleId(userRole.getRoleId());
		testUserRole.setName(userRole.getName());
		userRoles.add(new UserRole(testUser, testUserRole));

		userService.createUser(testUser, userRoles);

		userRoles.clear();

		User testAdminUser = new User();
		testAdminUser.setFirstName("Admin");
		testAdminUser.setLastName("Admin");
		testAdminUser.setUsername("admin");
		testAdminUser.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		testAdminUser.setEmail("Admin@gmail.com");
		Role testAdminUserRole = new Role();
		testAdminUserRole.setRoleId(adminRole.getRoleId());
		testAdminUserRole.setName(adminRole.getName());
		userRoles.add(new UserRole(testAdminUser, testAdminUserRole));

		userService.createUser(testAdminUser, userRoles);
	}

}