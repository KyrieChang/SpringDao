package com.servicetest;

import com.kyrie.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:app.xml")
public class UserServiceTest {
	@Resource
	private UserService userService;

	@Test
	public void testQuery(){
		userService.findUserById("");
		System.out.println("kyrie test read");
	}

	@Test
	public void testSave(){
		userService.save();
		System.out.println("kyrie test write");
	}
}
