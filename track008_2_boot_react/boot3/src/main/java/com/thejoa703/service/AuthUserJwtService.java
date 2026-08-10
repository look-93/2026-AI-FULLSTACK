package com.thejoa703.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.thejoa703.oauth2.CustomOAuth2User;

/*
jwt 인증 사용자 정보서비스
- Authentication 에서 CustomOAuth2User 에서 꺼내서 현재 로그인한 사용자 정보를 제공 
*/
@Component
public class AuthUserJwtService {  
	// 현재 로그인한 사용자 id 반환
    public Long getCurrentUserId(Authentication authentication) {
        CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
        return userPrincipal.getId();
    }
    
    // 현재 로그인한 사용자 email 반환
    public String getCurrentUserEmail(Authentication authentication) {
        CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
        return userPrincipal.getEmail();
    }
  
    // 현재 로그인한 사용자 닉네임 반환
    public String getCurrentUserNickname(Authentication authentication) {
        CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
        return userPrincipal.getNickname();
    }
}
