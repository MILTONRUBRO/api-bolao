package br.com.devmos.apibolao.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apibolao.model.Time;
import br.com.devmos.apibolao.model.TimeForm;

public abstract class CampoUnicoTimeValidator implements Validator{
	
	public abstract Optional<Time> buscaTimePorCampo(TimeForm form);

	@Override
	public boolean supports(Class<?> clazz) {
		return TimeForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TimeForm form = (TimeForm) target;
		
		Optional<Time> possivelTime = buscaTimePorCampo(form);
		
		if(possivelTime.isPresent()){
			String campoInvalido = getCampoInvalido();
			
			errors.rejectValue(campoInvalido, null, campoInvalido + " ja existente no banco de dados");
		}
	}

	public abstract String getCampoInvalido();

}
