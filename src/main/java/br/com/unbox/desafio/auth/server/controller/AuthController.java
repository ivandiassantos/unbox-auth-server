package br.com.unbox.desafio.auth.server.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unbox.desafio.auth.server.data.dto.NewUserDTO;
import br.com.unbox.desafio.auth.server.exception.BusinessException;
import br.com.unbox.desafio.auth.server.service.UserService;

@RestController
public class AuthController {
	private final UserService userService;

	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}

	@PostMapping(path = "/register-new-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity register(@RequestBody NewUserDTO dto) {
		try {
			userService.register(dto);
			return ResponseEntity.ok().build();
		}catch (BusinessException e) {
			return ResponseEntity.badRequest().body(e.getErrorMessage());
		}
	}
}
