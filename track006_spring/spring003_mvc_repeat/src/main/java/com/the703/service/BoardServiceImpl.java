package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectAll() {
		return boardMapper.selectAll();
	}

	@Override
	public BoardDto detail(int bno) {
		return boardMapper.detail(bno);
	}

	@Override
	public int insert(BoardDto dto) {
		
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}		
		return boardMapper.insert(dto);
	}
	
	@Override
	public BoardDto updateView(int bno) {
		return boardMapper.select(bno);
	}

	@Override
	public int update(BoardDto dto) {
		return boardMapper.update(dto);
	}

	@Override
	public int delete(BoardDto dto) {
		return boardMapper.delete(dto);
	}

	@Override
	public int updateBhit(int dno) {
		return boardMapper.updateBhit(dno);
	}
	
	
	
}
