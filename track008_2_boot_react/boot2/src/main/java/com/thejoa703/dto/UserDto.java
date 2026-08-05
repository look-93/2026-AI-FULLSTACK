package com.thejoa703.dto;

import java.time.LocalDateTime;

import com.thejoa703.entity.AppUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
	
	//응답/요청 dto 가 나눠져있어서 유지보수 용이
	// 회원가입 요청 Dto
	@NoArgsConstructor
	@AllArgsConstructor
	@Setter @Getter
	public static class UserRequestDto{
		@Email // 이메일 형식인지 검사
		@NotBlank //필수
		private String email;
		
		@NotBlank
		private String password;
		
		@NotBlank
		private String nickname;
		private String provider; //local
		private String mobile;
		private Integer mbtitype;
	}
	
	// 회원정보 응답 Dto
	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class UserResponseDto{
		private Long id;
		private String email;
		private String password;
		private String nickname;
		private String mobile; 		// 나중에확장
		private Integer mbtitype; 	// 나중에확장
		private String role;
		private String provider;
		private String ufile;
		private LocalDateTime createAt;
		
		public static UserResponseDto fromEntity(AppUser user) {
			return UserResponseDto.builder()
									.id(user.getId())
									.email(user.getEmail())
									.nickname(user.getNickname())
									.provider(user.getProvider())
									.role(user.getRole())									
									.ufile(user.getUfile())
									.createAt(user.getCreatedAt())
									.build();
		}
		
		public UserResponseDto(AppUser user) { //insert, update 결과물
			this.id = user.getId();
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.nickname = user.getNickname();
			this.mobile = user.getMobile();
			this.mbtitype = user.getMbtitype();
			this.role = user.getRole();
			this.provider = user.getProvider();
			this.ufile = user.getUfile();
		}
	}
}
