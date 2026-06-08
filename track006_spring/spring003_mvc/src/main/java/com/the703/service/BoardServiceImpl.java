package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public int insert(MvcBoardDto dto, MultipartFile file) {
		String fileName = "the703.png";
		if(!file.isEmpty()) {
			fileName = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File  demp = new File(uploadPath + fileName);
			try {
				file.transferTo(demp);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		dto.setBfile(fileName);
		return dao.insert(dto);
	}

	@Override
	public MvcBoardDto detail(int bno) {

		dao.updateBhit(bno); // 조회수 올리기
		return dao.detail(bno);
	}

	@Override
	public MvcBoardDto editView(int bno) {
		return dao.select(bno);
	}

	/*
	 * @Override public int edit(MvcBoardDto dto) { // 비번맞으면 수정 return
	 * dao.update(dto); }
	 */

	@Override
	public int edit(MvcBoardDto dto, MultipartFile file) {
		int result = -1; // 비번 안맞음
		
		MvcBoardDto find = dao.select(dto.getBno()); //해당유저찾기
		if (find.getBpass().equals(dto.getBpass())) { // 글번호의 비번과 사용자가 입력한 비번이 같은지 확인
			
			String fileName = dto.getBfile(); // #1. 기본파일명으로 들어간거 넣어놓고
			if(!file.isEmpty()) {
				fileName = file.getOriginalFilename();
				String uploadPath = "C:/file/";
				File  demp = new File(uploadPath + fileName);
				
				try {
					file.transferTo(demp); // #2.파일올리기
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			dto.setBfile(fileName); // #3.파일명셋팅
			result = dao.update(dto);
		}

		return result;
	}// 비번맞으면 수정

	@Override
	public int delete(MvcBoardDto dto) {
		int result = -1; // 비번 안맞음

		MvcBoardDto find = dao.select(dto.getBno());
		if (find.getBpass().equals(dto.getBpass())) {
			result = dao.delete(dto.getBno());
		}

		return result;
	}// 비번맞으면 삭제

	@Override
	public int updateBhit(int bno) {

		return dao.updateBhit(bno);
	}

	   /* paging */
	   /* paging */
	   @Override
	   public List<MvcBoardDto> select10(int pstartno) { 
	      HashMap<String,Integer> map = new HashMap<>();
	      map.put("start", (pstartno-1)*10); //// (1) 1 0번째부터  (2) 2  10번째 부터  (3)  3  20번째 부터
	      map.put("end"  ,  10);
	      return dao.select10(map);
	   }

	   @Override public int selectCnt() { return dao.selectCnt(); }
	
	

}
