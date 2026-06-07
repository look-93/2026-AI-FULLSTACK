package com.the703.service;

import java.util.List;

import com.the703.dto.BoardDto;

public interface BoardService {
	//전체리스트
	public List<BoardDto> selectAll();
	
	//글 상세보기
	public BoardDto detail(int bno);
	
	//글 쓰기 기능 
	public int insert(BoardDto dto);
	
	public BoardDto updateView(int bno);
	//글 수정 기능	
	public int update(BoardDto dto);
	
	//글 삭제 기능
	public int delete(BoardDto dto);
	
	//조회수 증가
	public int updateBhit(int dno);
}
