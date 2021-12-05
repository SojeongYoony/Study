package com.koreait.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
//	@Autowired
//	private User users;
	
	
	// DO NOT FORGET TO ADD START PAGE AT FIRST!
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("viewUser.do")
	public String u(Model model) {
	//	model.addAttribute("user", users);
		return "user/userDetail";
	}

}
