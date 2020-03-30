package br.com.unbox.desafio.auth.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.unbox.desafio.auth.server.data.dto.UserDTO;
import br.com.unbox.desafio.auth.server.data.entity.User;
import br.com.unbox.desafio.auth.server.data.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	private final UserRepository userRepository;

	@Autowired
	public AuthenticationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUsername(username);
		if (optional.isPresent()) {
			return new UserDTO(optional.get());
		}
		throw new UsernameNotFoundException("User " + username + " Not found");
	}

}
