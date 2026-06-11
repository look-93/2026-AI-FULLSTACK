package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {	
	public AuthUserDto  readAuth(String email);
	
	public int insert(UserDto dto);
	public String findEmail(String email);
	public String findNickname(String nickname);
	public int insertAuth(AuthDto dto);
	public UserDto findUser(String email);	
}


