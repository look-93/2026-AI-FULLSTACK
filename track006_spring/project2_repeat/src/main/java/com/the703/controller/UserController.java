package com.the703.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@RequestMapping(value="/users/join", method = RequestMethod.GET)
	public String join() {
		return "users/join";
	}
	
	@RequestMapping(value="/users/join", method = RequestMethod.POST)
	public String join_post(UserDto dto, RedirectAttributes rttr) {
		
		boolean result = userService.insert(dto) == 1;
		rttr.addFlashAttribute("result", result);						
		return "redirect:/users/login";
	
	}	
	
	@RequestMapping(value="/users/login", method = RequestMethod.GET)
	public String login() {
		return "users/login";
	}	
	
	@RequestMapping(value="/users/mypage", method = RequestMethod.GET)
	public String mypage(Model model, Principal principal) {
		model.addAttribute("dto",userService.findUser(principal.getName()));
		return "users/mypage";
	}	
}
