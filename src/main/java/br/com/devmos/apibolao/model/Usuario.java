package br.com.devmos.apibolao.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Usuario {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	@PastOrPresent
	private LocalDateTime instanteCriacao;
	
	 public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	public Usuario(@Email String login, @Size(min = 6) String senha) {
		this.login = login;
		setSenha(senha);
		instanteCriacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = PASSWORD_ENCODER.encode(senha);	}

	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}
	
}
