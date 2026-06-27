package com.the703;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	// tmptAdmin 복사해서 content안에 본인 hrml 붙여넣으면됩니다
	// 탬플릿 샘플
	@GetMapping("/tmptAdmin")
	public String tmpt() {return "tmptAdmin"; } //prefix(/templates) + tmpt + suffix(.html)

	// admin 페이지 샘플 
	@GetMapping("/samplePage/admin")
	public String admin() {return "/samplePage/admin"; }

	/*
	 * // mypage 페이지 샘플
	 * 
	 * @GetMapping("/fragments/myPageHeader") public String myPageHeader() {return
	 * "/fragments/myPageHeader"; }
	 */	

	// main 페이지 샘플 
	@GetMapping("/samplePage/meetupMain")
	public String myPageHeader() {return "/samplePage/meetupMain"; }		
}
