package br.com.devmos.apibolao.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apibolao.model.Campeonato;
import br.com.devmos.apibolao.model.CampeonatoForm;

public abstract class CampoUnicoCampeonatoValidator implements Validator {

	public abstract Optional<Campeonato> buscaCampeonatoPorCampo(CampeonatoForm form);

	@Override
	public boolean supports(Class<?> clazz) {
		return CampeonatoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CampeonatoForm form = (CampeonatoForm) target;

		Optional<Campeonato> possivelCampeonato = buscaCampeonatoPorCampo(form);

		if (possivelCampeonato.isPresent()) {
			String campoInvalido = getCampoInvalido();

			errors.rejectValue(campoInvalido, null, campoInvalido + " ja existente no banco de dados");
		}

	}

	public abstract String getCampoInvalido();

}
