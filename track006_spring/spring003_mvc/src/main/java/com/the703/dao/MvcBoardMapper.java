package com.the703.dao;

import java.util.List;

import com.the703.dto.MvcBoardDto;

@Mapper
public interface MvcBoardMapper {
	public List<MvcBoardDto> selectAll();
	public MvcBoardDto select(int bno);
	public int insert(MvcBoardDto dto);
	public int delete(MvcBoardDto dto);
	public MvcBoardDto detail(int bno);
	public int update(MvcBoardDto dto);
}
