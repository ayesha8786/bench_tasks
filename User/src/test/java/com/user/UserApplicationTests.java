package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.controller.UserController;

@SpringBootTest
class UserApplicationTests {
	@Autowired
	private UserController controller;

	@Test
	void contextLoads() {
		controller.testter();
	}

}
