package br.com.unbox.desafio.auth.server.data.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class NewUserDTO {
	private String name;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}

	public String getEncryptedPassword() {
		return new BCryptPasswordEncoder().encode(password);
	}

}
