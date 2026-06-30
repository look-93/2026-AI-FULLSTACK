package com.the703.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.AppUserDto;
import com.the703.security.CustomUserDetails;
import com.the703.service.AppuserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/users") //공동 prefix #1)
public class UserController {
	@Autowired AppuserService service;
	
	@GetMapping("/join")
	public String joinForm() {
		return "/users/join";
	}
	
	@PostMapping("/join")
	public String join(@RequestParam(value="file", required=false) MultipartFile file, AppUserDto dto, RedirectAttributes rttr) { // required=false 이미지 필수아님
		dto.setMbtiTypeId(1);	//확장버전 : mbti
		dto.setProviderId("1"); // UUID - 추가
		try {
			int result = service.insert(file, dto);
			rttr.addFlashAttribute("successMessage", result > 0 ? "회원가입성공" : "회원가입실패");
			return "redirect:/users/login";			
		}catch(Exception e) {
			rttr.addFlashAttribute("errorMessage", "회원가입실패" + e.getMessage());
			return "redirect:/users/join";									
		}
	}
	
	@ResponseBody
	@GetMapping("/iddouble")
	public Map<String, Object> iddouble(@RequestParam("email") String email) {
		Map<String, Object> result = new HashMap<>();
		result.put("exists", service.selectEmail(email, "local") != null);
		return result;
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "/users/login";
	}
	
	// 마이페이지
	@GetMapping("/mypage")
	public String mypage(Authentication authentication, Model model) { // authentication -> 사용자정보 가지고있는 principal 가지고있음
		String email = null, provider = null;
		Object principal = authentication.getPrincipal();
		//1. local
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails) principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
		}
		
		//2. social
		model.addAttribute("dto", service.selectEmail(email, provider));
		return "/users/mypage";
	}	
	
	// 수정
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/update")
	public String updateForm(Authentication authentication, Model model) {
		String email = null, provider = null;
		Object principal = authentication.getPrincipal();
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails) principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
		} // 로그인정보있으면 아래 실행
		
		model.addAttribute("dto", service.selectEmail(email, provider));
		return "/users/update";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update")
	public String update(@RequestParam(value="file", required = false) MultipartFile file, AppUserDto dto, RedirectAttributes rttr) {
		
		int result = service.update(file, dto);
		rttr.addFlashAttribute("successMessage", result > 0 ? "회원정보 수정 성공" : "회원정보 수정 실패");
		return "redirect:/users/mypage";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String deleteForm() {
		return "users/delete";
	}	
	
	@PreAuthorize("isAuthenticated()") // 로그인되어있는지 확인
	@PostMapping("/delete")
	public String delete(Authentication authentication, AppUserDto dto, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response ) {
		//사용자정보 - appUserId / email / provider(local : the703 , socila:kako-naver)
		String email = null, provider = null; 
		int appUserId = -1;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails) principal;
			email = users.getUser().getEmail();
			appUserId = users.getUser().getAppUserId();
			provider = users.getUser().getProvider();			
		}
		
		// 비밀번호 틀렸는지 확인
		if( ! service.matchesPassword(email, provider, dto.getPassword())) {
			rttr.addFlashAttribute("errorMessage", "사용자 정보를 확인해주세요");
			return "redirect:/users/delete";
		}
		
		// 탈퇴 - 유저정보 삭제
		dto.setEmail(email);
		dto.setAppUserId(appUserId);
		dto.setProvider(provider);		
		int result = service.delete(dto, true); // local
		if(result > 0) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // session 이랑 관련된 정보를 가지고있음 -> 세션까지 삭제해줌 
			if(auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);

			}
			rttr.addFlashAttribute("successMessage","탈퇴성공");
			return "redirect:/users/login";
		}else {
			rttr.addFlashAttribute("errorMessage", "탈퇴실패");
			return "redirect:/users/delete";			
		}

	}
	
	@GetMapping("/fail")
	public String fail(Model model) {
		model.addAttribute("errorMessage", "로그인 실패 : 아이디 또는 비밀번호를 확인해주세요.");
		return "/users/delete";
	}		
	
}
