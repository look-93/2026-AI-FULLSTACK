package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
public class UserController {
	@Autowired UserService userService;
	
	@RequestMapping(value="users/join.do", method = RequestMethod.GET)
	public String join() {
		return "users/join";
	}
	
	//회원가입기능
	@RequestMapping(value="users/join.do", method = RequestMethod.POST)
	public String join_post(UserDto dto, RedirectAttributes rttr) {
		
		String result = "실패";
		
		if(userService.insert(dto) > 0) {
			result = "성공!";
		}
		rttr.addFlashAttribute("result", result);
				
		return "redirect:/users/login.do";
	}
	
	
	@RequestMapping("/users/login.do")
	public String login() {
		return "users/login";
	}
	
	@RequestMapping("/users/mypage.do")
	public String mypqge() {
		return "users/mypage";
	}
	

}

