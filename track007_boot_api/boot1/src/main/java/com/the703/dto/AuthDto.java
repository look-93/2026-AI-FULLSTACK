package com.the703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private Integer authId;
	private String email;
	private String auth;
	private Integer appUserId;
}