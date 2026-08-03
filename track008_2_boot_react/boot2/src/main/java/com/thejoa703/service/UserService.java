package com.thejoa703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //데이터 저장(insert)시 rollback / 
// readOnly = true -> 변경 감지(Dirty Checking)를 하지 않음 , 성능이 조금 더 좋아짐, 실수로 데이터를 수정하는 것을 방지
// 만약 signup() 을 만든다면 @Transactional 붙혀주면 쓰기가 되고 나머지는 읽기전용이 됨
public class UserService {
	private final AppUserRepository appUserRepository; //## @Autowired 대신 @RequiredArgsConstructor로 생성자 생성
	
	//1. 회원가입(사용자등록)
	@Transactional
	public UserResponseDto createUser(UserRequestDto requestDto) {
//		// 이메일 중복검사
//		if(appUserRepository.existsByEmail(requestDto.getEmail())) {
//			throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
//		}
//		
//		// 닉네임 중복검사
//		if(appUserRepository.existsByNickname(requestDto.getNickname())) {
//			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
//		}		
		
		AppUser appUser = AppUser.builder()
							.email(requestDto.getEmail())
							.password(requestDto.getPassword())
							.nickname(requestDto.getNickname())
							.mobile(requestDto.getMobile())
							.mbtitype(requestDto.getMbtitype())
							.provider("local")
							.providerId("local") //소셜로그인 아이디값				
							.role("ROLE_USER")
							.deleted(false)
							.build();
		AppUser savedUser = appUserRepository.save(appUser);
		
		return new UserResponseDto(savedUser);		
	}
	
	//2. 사용자 단건조회
	public UserResponseDto getUser(Long id) {//Optional - 값 1개 or null
		AppUser appUser = appUserRepository.findById(id)
											.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다.id" + id));
		
		return new UserResponseDto(appUser);
	}
}
