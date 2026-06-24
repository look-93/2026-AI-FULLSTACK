package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	//localhost:8080/tmpt
	//@RequestMapping("/tmpt)
	@GetMapping("/tmpt")
	public String tmpt() {return "tmpt"; } //prefix(/templates) + tmpt + suffix(.html)
}
