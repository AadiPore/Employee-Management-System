package com.cato.core.billing.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/common/test")
public class TestController {

	@GetMapping("/hello")

	public String hello()
	{
		return "Private Acc.";
	}


	@GetMapping("/hii")
	public String hii()
	{
		return "Public Acc.";
	}
	@GetMapping("/hi")
	public String hi()
	{
		return "am hi.";
	}
}
