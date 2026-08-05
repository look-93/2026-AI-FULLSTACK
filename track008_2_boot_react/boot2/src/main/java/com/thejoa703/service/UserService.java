package com.thejoa703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.exception.ResourceNotFoundException;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.FollowRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //데이터 저장(insert)시 rollback / 
// readOnly = true -> 변경 감지(Dirty Checking)를 하지 않음 , 성능이 조금 더 좋아짐, 실수로 데이터를 수정하는 것을 방지
// 만약 signup() 을 만든다면 @Transactional 붙혀주면 쓰기가 되고 나머지는 읽기전용이 됨
public class UserService {

    private final FollowRepository followRepository;
	private final AppUserRepository appUserRepository; //## @Autowired 대신 @RequiredArgsConstructor로 생성자 생성
	//파일올리기
	private final FileStorageService fileStorageService;

	//보안: 비밀번호암호화	
	
	//CREATE : 회원가입
	@Transactional
	public UserResponseDto createUser(UserRequestDto request, MultipartFile profileImage) {
		String provider = request.getProvider() != null ? request.getProvider() : "local";
		
		// 이메일중복검사
		// isPresent() false 면 오류던져라
		if( appUserRepository.findByEmailAndProvider(request.getEmail(), provider).isPresent() ) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
		}
		
		//닉네임중복검사
		// exists -> true false 던져줌
		if( appUserRepository.existsByNickname(request.getNickname()) ) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
		}			
		
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // #암호화
        user.setNickname(request.getNickname());
        user.setProvider(provider);
        user.setRole("ROLE_USER");
        
        user.setUfile(profileImage != null && !profileImage.isEmpty() 
        			? fileStorageService.upload(profileImage) 
        		    : "uploads/thejoa703.png");	
        
		return UserResponseDto.fromEntity(appUserRepository.save(user));
	}
	
	//Read : 이메일중복검사
	public boolean existsByEmail(String email) {
		return appUserRepository.existsByEmail(email);
	}
	
	//Read : 닉네임중복검사
	public boolean existsByNickname(String nickname) {
		return appUserRepository.existsByNickname(nickname);
	}
	
	//Read : 로그인
	public UserResponseDto login(LoginRequest request) {
		AppUser user = appUserRepository
						.findByEmailAndProvider(request.getEmail()
											   ,request.getProvider() != null? request.getProvider() : "local")
						.orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));
		
		return UserResponseDto.fromEntity(user);		
	}
	
	//Read : 사용자 단건조회, 
	public UserResponseDto getUser(Long userId) {//Optional - 값 1개 or null
		AppUser user = appUserRepository.findById(userId)
											.orElseThrow(()-> new ResourceNotFoundException("존재하지 않는 사용자입니다.id" + userId));
		
		return UserResponseDto.fromEntity(user);
	}
	
	//READ : 전체사용자 수 
	public long countUsers() {return appUserRepository.count();}
	
	//UPDATE : 닉네임변경
	@Transactional
	public UserResponseDto updateNickname(Long userId, String newNickname) {
		if(appUserRepository.existsByNickname(newNickname)) {
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
		}
		
		//해당하유저번호 받아서 유저찾기
		AppUser user = appUserRepository.findById(userId)
										.orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다.id" + userId));
		
		//수정
		user.setNickname(newNickname); // 값변경 -> 트렌젝션 종료시 자동 (save 한 효과)
		
		return UserResponseDto.fromEntity(user);
	}
	
	//UPDATE : 프로필이미지변경
	@Transactional
	public UserResponseDto updateProfileImage(Long userId, MultipartFile profileImage) {
		
		//해당하유저번호 받아서 유저찾기
		AppUser user = appUserRepository.findById(userId)
										.orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다.id" + userId));
		
		//수정
		user.setUfile(profileImage != null && !profileImage.isEmpty()
					 ? fileStorageService.upload(profileImage)
					 : "upload/thejoa703.png");
		
		return UserResponseDto.fromEntity(user);
	}	
	
	//DELETE : 회원탈퇴
	@Transactional
	public void deleteById(Long userId) {
		if(!appUserRepository.existsById(userId)) {
			throw new ResourceNotFoundException("삭제할 사용자가 존재하지 않습니다." + userId);
		}
		appUserRepository.deleteById(userId);
	}		
	
}
