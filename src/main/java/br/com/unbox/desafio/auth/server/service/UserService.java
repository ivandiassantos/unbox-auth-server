package br.com.unbox.desafio.auth.server.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unbox.desafio.auth.server.data.dto.NewUserDTO;
import br.com.unbox.desafio.auth.server.data.entity.User;
import br.com.unbox.desafio.auth.server.data.repository.UserRepository;
import br.com.unbox.desafio.auth.server.exception.BusinessException;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void register(NewUserDTO dto) throws BusinessException{
		Optional<User> optional = userRepository.findByUsername(dto.getUsername());
		if(optional.isEmpty()) {
			throw new BusinessException("Já existe um usuário com este e-mail. Informe outro.");
		}
		User user = new User(dto);
		userRepository.save(user);
	}
	
	
}
