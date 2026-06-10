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
@RequestMapping("/security/*")
public class SecurityController {
	@Autowired
	UserService userService;

	@RequestMapping("/all")
	public String all() {
		return "security/all";
	}

	@RequestMapping("/member")
	public String member() {
		return "security/member";
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "security/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join_post(UserDto dto, RedirectAttributes rttr) {
		System.out.println("..........." + dto);
		String result = "회원가입실패";
		if (userService.insert(dto) > 0) {
			result = "회원가입 성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/security/login";
	}

	@RequestMapping("/login")
	public String login() {
		return "security/login";
	}

	@RequestMapping("/fail")
	public String fail() {
		return "security/fail";
	}

	// Authentication 그림 9,10번 - Principal(현재 로그인한 사용자정보만 가르쳐좀)
	@RequestMapping("/mypage")
	public String mypage(Principal principal, Model model) {
		System.out.println("....." + principal);
		System.out.println("....." + principal.getName()); // username -> email
		// model.addAttribute("email", principal.getName());
		 model.addAttribute("dto", userService.findUser(principal.getName()));

		Object dto = userService.findUser(principal.getName());

		System.out.println("dto = " + dto);

		// mapper - email 검색시 해당유저 정보 가져오기
		model.addAttribute("dto", dto);
		return "security/mypage";
	}// LoginSuccessHandler.jave에서 사용

	// logout 컨트롤러 탈 필요x
}
