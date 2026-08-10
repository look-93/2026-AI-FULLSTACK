package com.thejoa703.security;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

//2. 토근 발급/검증
@Component
public class JwtProvider {
	
    // application.yml 에 jwt 설정을 props 로 가져옴
	private final JwtProperties props;  // 토큰 - 출입증 
    
    private final SecretKey key;    // jwt에 서명에 사용할 key
 
    //생성자
    public JwtProvider(JwtProperties props) {
        this.props = props;
        this.key = Keys.hmacShaKeyFor(props.getSecret().getBytes()); //서명용키를 생성  
    }
    
    // AccessToke 생성
    public String createAccessToken(String subject, Map<String, Object> claims) {  
        Instant now = Instant.now(); // 토큰생성시간
        Instant exp = now.plusSeconds(props.getAccessTokenExpSeconds()); //만료시간계산
        return Jwts.builder()
                .setIssuer(props.getIssuer())  	// 발급자
                .setSubject(subject)     		// 사용자
                .addClaims(claims)        		// 추가정보
                .setIssuedAt(Date.from(now))   // 발급시간
                .setExpiration(Date.from(exp))  	//만료시간
                .signWith(key, SignatureAlgorithm.HS256)   // HS256 알고리즘 서명
                .compact();
    }
    
    // RefreshToken
    public String createRefreshToken(String subject) {   
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(props.getRefreshTokenExpSeconds());   // 만료시간 더길게
        return Jwts.builder()
                .setIssuer(props.getIssuer())
                .setSubject(subject)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(exp))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    } 
    
    //토큰 파싱과 검증
    public Jws<Claims> parse(String token) {  
        return Jwts.parserBuilder()
                .setSigningKey(key) //서명용 키를 이용해서 토큰 검증   
                .requireIssuer(props.getIssuer())   // 발급자과 일치하는지 확인
                .build()
                .parseClaimsJws(token);
    }
}
