package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/list.do")
	public String list() {
		return "board/list"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}
	
	@RequestMapping("board/write.do")
	public String write() {
		return "board/write"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}
	
	@RequestMapping("/board/detail.do")
	public String detail() {
		return "board/detail"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}
	
	@RequestMapping("/board/edit.do")
	public String edit() {
		return "board/edit"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}
	
	@RequestMapping("/board/delete.do")
	public String delete() {
		return "board/delete"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}	
	

}
