package com.the703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.service.UserService;

public class CustonUserDetailsService implements UserDetailsService{

	@Autowired UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//우리는 유저네임아니고 이메일
		
		AuthDto adto = new AuthDto(); adto.setEmail(username); 
		AuthListDto dto = userService.readAuth(adto);
		
		return dto == null ? null : new CustomUser(dto);
	}
}


/* loadUserByUsername -> mapper 에서 해당한는 값들 가져옴 */