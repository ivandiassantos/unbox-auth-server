package br.com.unbox.desafio.auth.server.data.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.unbox.desafio.auth.server.data.dto.NewUserDTO;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	public User(){}
	
	public User(NewUserDTO dto) {
		this.name = dto.getName();
		this.username = dto.getUsername();
		this.password = dto.getEncryptedPassword();		
		this.registrationDate = LocalDate.now();
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

}
