package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	//■1.전체리스트
	@RequestMapping("/board/list.do")
	public String list(Model model) {
		model.addAttribute("list",  boardService.selectAll());
		return "board/list";
	}
	
	//■2. 글쓰기 폼경로
	@RequestMapping(value="/board/write.do",method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	//■3. 글쓰기 기능
	@RequestMapping(value="/board/write.do",method = RequestMethod.POST)
	public String write_post(BoardDto dto, RedirectAttributes rttr) {
		
		boolean result = boardService.insert(dto)>0;		
		/*
		 * if(boardService.insert(dto)>0) { result = "글쓰기성공"; }
		 */
		
		rttr.addFlashAttribute("result",result);
		return "redirect:/board/write.do";
	}	
	
	//■4. 글상세보기
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		boardService.updateBhit(bno);
		model.addAttribute("dto", boardService.detail(bno));
		return "board/detail";
	}
	
	//■5. 글수정 폼경로
	@RequestMapping(value="/board/edit.do", method = RequestMethod.GET)
	public String edit(int bno, Model model) {		
		model.addAttribute("dto", boardService.updateView(bno));
		return "board/edit";
	}
	
	//■5. 글수정 기능
	@RequestMapping(value="/board/edit.do", method= RequestMethod.POST)
	public String edit_post(BoardDto dto, RedirectAttributes rttr) {
		
		boolean result = boardService.update(dto) > 0;		
		rttr.addFlashAttribute("result", result);
		return "redirect:/board/edit.do?bno="+dto.getBno();
	}
		
	@RequestMapping(value="/board/delete.do", method = RequestMethod.GET)
	public String delete() {
		return "board/delete";
	}
	
	//■6. 글삭제 기능	
	@RequestMapping(value="/board/delete.do", method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr){
		
		boolean result = boardService.delete(dto) > 0;
			
		rttr.addFlashAttribute("result", result);
//		return "board/delete";
		return "redirect:/board/delete.do?bno="+dto.getBno();
	}
}
