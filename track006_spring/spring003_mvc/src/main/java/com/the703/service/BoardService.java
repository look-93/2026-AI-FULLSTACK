package com.the703.service;

import java.util.List;

import com.the703.dto.MvcBoardDto;

public interface BoardService {
	//■1.  전체리스트
	public List<MvcBoardDto> selectAll();
	//■2. 글쓰기 기능 
	public int insert(MvcBoardDto dto);
	//■3. 글상세보기 - 조회수올리기 / 해당글
	public MvcBoardDto detail(int bno); 
	//■4. 글수정폼 경로 - 해당글 
	public MvcBoardDto editView(int bno);
	//■4. 글수정 기능 	- 비밀번호가 맞는지 확인 후 글수정
	public int edit(MvcBoardDto dto);
	//■5. 글삭제 기능	- 비밀번호가 맞는지 확인 후 글삭제
	public int delete(MvcBoardDto dto);
}
