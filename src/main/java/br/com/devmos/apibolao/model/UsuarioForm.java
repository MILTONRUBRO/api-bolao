package br.com.devmos.apibolao.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class UsuarioForm {
	
	@NotNull
	@Email
	private String login;
	
	@NotNull
	@Size(min = 6)
	private String senha;
	
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario novo() {
		return new Usuario(login, senha);
	}

}
