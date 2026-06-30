package com.the703;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	// tmptAdmin 복사해서 content안에 본인 html 붙여넣으면됩니다
	
	// 탬플릿 샘플
	@GetMapping("/tmptAdmin")
	public String tmptAdmin() {return "/base/tmptAdmin"; } //prefix(/templates) + tmpt + suffix(.html)
	
	@GetMapping("/tmptMain")
	public String tmptMain() {return "/base/tmptMain"; } //prefix(/templates) + tmpt + suffix(.html)

	@GetMapping("/tmptMeetupList")
	public String tmptMeetupList() {return "/base/tmptMeetupList"; } //prefix(/templates) + tmpt + suffix(.html)
	
	@GetMapping("/tmptMypage")
	public String tmptMypage() {return "/base/tmptMypage"; } //prefix(/templates) + tmpt + suffix(.html)

	// admin 페이지 샘플 
	@GetMapping("/samplePage/admin")
	public String admin() {return "/samplePage/admin"; }

	// main 페이지 샘플 
	@GetMapping("/samplePage/main")
	public String main() {return "/samplePage/main"; }

	// meetupList 페이지 샘플 
	@GetMapping("/samplePage/meetupList")
	public String myPageHeader() {return "/samplePage/meetupList"; }		
	
	// mypage 페이지 샘플 
	@GetMapping("/samplePage/mypage")
	public String mypage() {return "/samplePage/mypage"; }		
	
	
}
