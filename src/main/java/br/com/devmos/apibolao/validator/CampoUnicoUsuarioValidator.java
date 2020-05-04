package br.com.devmos.apibolao.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apibolao.model.Usuario;
import br.com.devmos.apibolao.model.UsuarioForm;

public abstract class CampoUnicoUsuarioValidator  implements Validator{
	
	public abstract Optional<Usuario> buscaUsuarioPorCampo(UsuarioForm form);

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UsuarioForm form = (UsuarioForm) target;
		
		Optional<Usuario> possivelUsuario = buscaUsuarioPorCampo(form);
		
		if(possivelUsuario.isPresent()){
			String campoInvalido = getCampoInvalido();
			errors.rejectValue(campoInvalido, null,  campoInvalido + " ja existente no banco de dados" );
		}
	}

	public abstract String getCampoInvalido();
	
	

}
