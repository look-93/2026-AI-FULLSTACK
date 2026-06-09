package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.MvcBoardDto;

@Mapper
public interface MvcBoardMapper {
	public List<MvcBoardDto> selectAll();
	public MvcBoardDto select(int bno);
	public int insert(MvcBoardDto dto);
	public int delete(int bno);
	public MvcBoardDto detail(int bno);
	public int update(MvcBoardDto dto);
	public int updateBhit(int bno);
	
	//paging
	public List<MvcBoardDto> select10(HashMap<String, Integer> map);
	public int selectCnt();
}
