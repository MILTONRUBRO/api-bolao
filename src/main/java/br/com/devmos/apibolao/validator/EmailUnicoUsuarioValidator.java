package br.com.devmos.apibolao.validator;

import java.util.Optional;

import br.com.devmos.apibolao.model.Usuario;
import br.com.devmos.apibolao.model.UsuarioForm;
import br.com.devmos.apibolao.repository.UsuarioRepository;

public class EmailUnicoUsuarioValidator extends CampoUnicoUsuarioValidator{
	
	private UsuarioRepository usuarioRepository;
	
	public EmailUnicoUsuarioValidator(UsuarioRepository usuarioRepository){
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Optional<Usuario> buscaUsuarioPorCampo(UsuarioForm form) {
		return usuarioRepository.findByLogin(form.getLogin());
	}

	@Override
	public String getCampoInvalido() {
		return "login";
	}

}
