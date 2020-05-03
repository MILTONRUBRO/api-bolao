package br.com.devmos.apibolao.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apibolao.model.Usuario;
import br.com.devmos.apibolao.model.UsuarioForm;
import br.com.devmos.apibolao.repository.UsuarioRepository;
import br.com.devmos.apibolao.validator.EmailUnicoUsuarioValidator;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@InitBinder("usuarioForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new EmailUnicoUsuarioValidator(usuarioRepository));
	}
	
	@PostMapping(value="api/usuario")
	@Transactional
	public void adicionar(@Valid @RequestBody UsuarioForm usuarioForm) {
		
		Usuario usuario = usuarioForm.novo();
		
		usuarioRepository.save(usuario);
		
	}

} 
