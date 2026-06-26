package com.the703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private Integer appUserId;
	private String email;
	private String password;
	private Integer mbtiTypeId;
	private String createdAt;
	private String ufile;
	private String mobile;
	private String nickname;
	private String provider;
	private String providerId;
}