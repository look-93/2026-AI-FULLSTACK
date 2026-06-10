package com.the703.dao;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public int insert(UserDto dto);
	public int findLogin(UserDto dto);
	public UserDto findMypage(int uno);
	public String findEmail(String email);	
	
	public UserDto findUser(String email);
	
	/*security*/
	public int insertAuth(AuthDto dto);
	public AuthListDto readAuth(AuthDto dto);
}
