package com.the703.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.the703.api.ApiEmail;
import com.the703.api.ApiNaverBook;
import com.the703.api.BookDto;

@Controller
@RequestMapping("/api/util")
public class ApiUtilController {
	
	//////////// 1. mail
	@Autowired ApiEmail apiEmail;
	@GetMapping("/mail") 
	public String get_mail() {
		return "util/mail";
	}
	
	@PostMapping("/mail")
	/* @ResponseBody ajax*/
	public String post_mail(String subject, String content, String email) {
		apiEmail.sendEmail(subject, content, email);
		
		return "util/mail_result";
	}
	//////////// 2. 스케줄러
	
	//////////// 3. books
	@Autowired ApiNaverBook apibook;
	@GetMapping("/books")
	public String books() {
		return "util/books";
	}
	
	// http://localhost:8080/api/util/books/json?search=spring 테스트
	@GetMapping(value="/books/json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookDto> books_json(@RequestParam String search){
		return apibook.getBooks(search);
	}
	
}
