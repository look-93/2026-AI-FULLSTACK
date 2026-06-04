package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	
	/*
	 * <property name="prefix" value="/view/" /> <!--폴더 -->
	 * <property name="suffix" value=".jsp"/> <!-- 확장자 -->
	 */
	@RequestMapping("/basic.do")
	public String basic(Model model) {
		model.addAttribute("result", "Hello");
		return "basic"; // /view/ + basic + .jsp
	}
	
}
