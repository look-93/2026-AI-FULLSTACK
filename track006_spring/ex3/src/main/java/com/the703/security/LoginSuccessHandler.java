package com.the703.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{ // ## 인증(누구)

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//## 인가(접근,허용)
		List<String> roles = new ArrayList<>();
		authentication.getAuthorities().forEach(auth -> {
			roles.add(auth.getAuthority());
		});
		
		//각각의 유저처리
		// 각 유저의 권한을 확인해서 접근할 수 있는 페이지로 이동 
		// ex) if(roles.contains("ROLE_ADMIN")){ response.sendRedirect(request.getContextPath() + "/security/admin");	 }
		
		response.sendRedirect(request.getContextPath() + "/security/mypage");		
	}

}
