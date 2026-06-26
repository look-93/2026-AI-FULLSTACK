package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;

@Controller
@RequestMapping("/board") //공동 prefix #1)
public class Sboard2Controller {
	@Autowired private Sboard2Service service;
	
	// 전체리스트
	@GetMapping("/list") // #2) /board/list
	public String list(Model model, @RequestParam(value="pageNo", defaultValue="1") int pageNo) { //model: view 값 넘기기, pageNo: 페이지번호		
		model.addAttribute("paging", new UtilPaging(service.selectCnt(), pageNo));
		model.addAttribute("list", service.list10(pageNo));
		/* System.out.println(new UtilPaging(service.selectCnt(), pageNo)+"ddddd"); */
		return "board/list"; //prefix(/templates) + tmpt + suffix(.html)
	}
	
	//2. 글쓰기 폼	
	@GetMapping("/write") // #2) GET : /board/write
	public String write() {	
		return "board/write";
	}
	
	//3. 글쓰기 기능
	@PostMapping("/write") // #2) GET : /board/write
	public String writePost(MultipartFile file, Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		if(service.insert(file, dto) > 0) {
			result = "글쓰기성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list";
	}
	
	//4. 상세보기
	@GetMapping("/detail") // #2) GET : /board/detail
	public String detail(Model model, Sboard2Dto dto) {
		model.addAttribute("dto", service.detail(dto));
		return "board/detail";
	}	
	
	//5. 수정폼
	@GetMapping("/edit") // #2) GET : /board/edit
	public String edit(Model model, Sboard2Dto dto) {
		model.addAttribute("dto", service.updateForm(dto));
		return "board/edit";
	}		
	
	//6. 수정 기능
	@PostMapping("/edit") // #2) POST : /board/write
	public String editPost(MultipartFile file, Model model, Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "비밀번호를 확인하세요.";
		if(service.update(file, dto) > 0) {
			result = "글수정 성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/detail?id="+dto.getId();
	}	
	
	//7. 삭제 폼
	@GetMapping("/delete") // #2) GET : /board/delete
	public String delete() {		
		return "board/delete";
	}		
	
	//8. 삭제기능
	@PostMapping("/delete") // #2) POST : /board/delete
	public String deletePost(Sboard2Dto dto, RedirectAttributes rttr) {
		String result ="비밀번호를 확인하세요.";
		if(service.delete(dto) > 0) {
			result = "글삭제 성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list";
	}		
}


