package com.the703.dao;

import java.util.List;

import com.the703.dto.UserInfoDto;

@Mapper
public interface UserInfoMapper {
	public int insert(UserInfoDto dto);
	public UserInfoDto selset(int no);
	public List<UserInfoDto> selsetAll();
	public int update(UserInfoDto dto);
	public int delete(int no);
}
