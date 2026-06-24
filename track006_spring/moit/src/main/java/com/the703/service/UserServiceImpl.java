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
public class UserServiceImpl  implements UserService{
 
	@Autowired  UserMapper dao;
	@Autowired  @Qualifier("passwordEncoder") PasswordEncoder  pwencoder;
	//import org.springframework.security.crypto.password.PasswordEncoder;
	
	@Override public AuthUserDto readAuth(String email) { return dao.readAuth(email); }

	@Override
	public int insert(UserDto dto) {
		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail());
		adto.setAuth("ROLE_MAMBER");
		dao.insertAuth(adto);
		
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		dto.setBpass(pwencoder.encode(dto.getBpass()));
		
		return dao.insert(dto);
	}

	@Override
	public UserDto findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public UserDto findByEmailUserInfo(String email) {
		return dao.findByEmailUserInfo(email);
	}

	@Override
	public UserDto findByNickname(String nickname) {
		return dao.findByNickname(nickname);
	}

	@Override
	public int insertAuth(AuthDto dto) {
		return 0;
	}

	
	
}
