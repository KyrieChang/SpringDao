package com.kyrie.web;

import com.kyrie.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("test/kyrie/")
public class TestController {
	@Resource
	private UserService userService;

	@RequestMapping("testQuery")
	public void testQuery(){
		userService.findUserById("");
	}
	
	@RequestMapping("testSave")
	public void testSave(){
		userService.save();
	}
}
