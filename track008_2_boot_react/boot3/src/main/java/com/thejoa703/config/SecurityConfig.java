package com.thejoa703.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.thejoa703.oauth2.OAuth2SuccessHandler;
import com.thejoa703.security.JwtAuthenticationFilter;
import com.thejoa703.security.JwtProvider;

import lombok.RequiredArgsConstructor;

/*
Spring Security 설정
 - csrf / formLogin /  httpBasic 비활성화 
 - cors 설정 (react 에서 접속가능여부)
*/ 

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http 
        	//기본보안기능 비활성화
            .csrf(csrf -> csrf.disable())		 //비활성화
            .formLogin(form -> form.disable())   //비활성화
            .httpBasic(basic -> basic.disable()) //비활성화
            
            //cors 설정
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            //세션설정 - STATELESS , Spring Security에서 세션을 사용하지 않겠다는 설정
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            //권한설정
            .authorizeHttpRequests(auth -> auth
            	// swagger, 인증관련경로 권한설정
                .requestMatchers(
                    "/auth/**", "/login/**", "/oauth2/**",
                    "/swagger-ui/**", "/v3/api-docs/**",
                    "/swagger-resources/**", "/webjars/**", 
                    "/configuration/**", "/uploads/**"  , "/api/deptusers/**" , "/api/likes/**"
                ).permitAll() // 허용
                
                // 해쉬태그
                .requestMatchers(HttpMethod.GET, "/api/posts/search/hashtag").permitAll()  
                
                // 전체 조회용
                .requestMatchers(HttpMethod.GET, "/api/posts").permitAll()   
                
                // 단건조회용
                .requestMatchers(HttpMethod.GET, "/api/posts/**").permitAll() 
                .requestMatchers("/api/posts/paged").permitAll() 
                
                // /api/ 요청은 jwt 인증필요
                .requestMatchers("/api/**").authenticated()
                // 나머지는 모두 허용
                .anyRequest().permitAll()
            )
            // Oauth2 로그인은 소셜로그인전용
            .oauth2Login(oauth2 -> oauth2.successHandler(oAuth2SuccessHandler))
            // 시큐리티 체인안에서 동작
            .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
 
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));  //★ Front 포트번호

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); //
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
