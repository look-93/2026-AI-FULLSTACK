package com.the703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private String email;
	private String bpass;
	private String auth; //권한 하나
}
