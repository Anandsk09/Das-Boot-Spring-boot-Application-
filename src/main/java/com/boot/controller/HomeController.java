package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(value="/homeController")
	public String getHomeController()
	{
		return "Home Controller for Ship wreck application";
	}

}
