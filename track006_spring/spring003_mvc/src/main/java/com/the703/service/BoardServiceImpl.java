package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.MvcBoardMapper;
import com.the703.dto.MvcBoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	MvcBoardMapper dao; // db관련

	@Override
	public List<MvcBoardDto> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insert(MvcBoardDto dto) {
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return dao.insert(dto);
	}

	@Override
	public MvcBoardDto detail(int bno) {
		// 조회수 올리기
		return dao.detail(bno);
	}

	@Override
	public MvcBoardDto editView(int bno) {
		return dao.select(bno);
	}

	@Override
	public int edit(MvcBoardDto dto) {
		// 비번맞으면 수정
		return dao.update(dto);
	}

	@Override
	public int delete(MvcBoardDto dto) {
		// 비번 맞으면 삭제		
		//System.out.println(".........................."+dto);
		int result = dao.delete(dto); 
		//System.out.println(".........................."+result);
		return result;
	}

}
