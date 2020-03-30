package br.com.unbox.desafio.auth.server.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unbox.desafio.auth.server.data.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUsername(String username);

}
