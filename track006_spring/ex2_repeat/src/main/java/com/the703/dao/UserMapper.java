package com.the703.dao;

import java.util.List;

import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {

	public UserDto select(int uno);
	public List<UserDto> selectAll();
	public int insert(UserDto dto);
	public int update(UserDto dto);
}
