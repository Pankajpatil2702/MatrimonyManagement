package com.example.MatrimonyManagement.response;

import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse {
	
	private String token;
	private Role role;
	private Object data;

}
