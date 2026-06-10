package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;


public interface UserService {
	
	//회원가입 + 권한추가
	public int insert(UserDto dto);
	//로그인기능
	public int findLogin(UserDto dto);
	//마이페이지
	public UserDto findMypage(int uno);
	//이메일 중복검사
	public String findEmail(String email);	
	
	// email 검색시 해당유저 정보 가져오기
	public UserDto findUser(String email);
	 
	/* security login*/
	public AuthListDto readAuth(AuthDto dto);
	
	
	
}
