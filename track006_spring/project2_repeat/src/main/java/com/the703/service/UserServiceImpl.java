package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper userMapper;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Override
	public AuthUserDto readAuth(String email) {
		return userMapper.readAuth(email);
	}

	@Override
	public int insert(UserDto dto) {
		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail());
		adto.setAuth("ROLE_MEMBER");
		userMapper.insertAuth(adto);
		dto.setBpass(pwencoder.encode(dto.getBpass()));
		
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return userMapper.insert(dto);
	}

	@Override
	public String findEmail(String email) {
		return userMapper.findEmail(email);
	}

	@Override
	public int insertAuth(AuthDto dto) {
		return userMapper.insertAuth(dto);
	}

	@Override
	public String findNickname(String nickname) {
		
		return userMapper.findNickname(nickname);
	}

	@Override
	public UserDto findUser(String email) {
		return userMapper.findUser(email);
	}
	
	
	
	
	
	
	
}
