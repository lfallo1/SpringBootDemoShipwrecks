package com.lancefallon.boot.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	@RequestMapping("/")
	public String home(){
		return "Spring boot demo, home page";
	}
	
}
