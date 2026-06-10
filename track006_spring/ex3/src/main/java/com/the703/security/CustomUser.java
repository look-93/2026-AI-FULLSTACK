package com.the703.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.the703.dto.AuthListDto;

import lombok.Getter;

@Getter
public class CustomUser extends User{ //## 사용자정보

	private static final long serialVersionUID = 8898560806394691845L;
	AuthListDto dto;
	//String email;
	
	//2. 유저아이디와 비밀번호를 받아서 권한이 있는지 체크
	public CustomUser(String username, 
					  String password, 
					  Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	//1. 유저이메일(유저아이디)과 비밀번호를 받아서 권한이 다른경우 맞게 셋팅
	public CustomUser(AuthListDto dto) { //해당데이터 받아서 위쪽CustomUser 로 맞게 셋팅
		super(dto.getEmail(), // db상 email bpass 를 dto 를 가져와서 
			  dto.getBpass(), 
			  dto.getAuthList()
			  .stream()
			  .map(auth->new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList()) 
			 );
		//email = dto.getEmail(); 이렇게하면 jsp -> principal.dto.email
		this.dto = dto; // dto에 꽂아줌 
	}	
}
