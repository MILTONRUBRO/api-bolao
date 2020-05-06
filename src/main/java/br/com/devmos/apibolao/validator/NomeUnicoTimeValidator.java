package br.com.devmos.apibolao.validator;

import java.util.Optional;

import br.com.devmos.apibolao.model.Time;
import br.com.devmos.apibolao.model.TimeForm;
import br.com.devmos.apibolao.repository.TimeRepository;

public class NomeUnicoTimeValidator extends CampoUnicoTimeValidator{
	
	private TimeRepository timeRepository;
	
	public NomeUnicoTimeValidator(TimeRepository timeRepository){
		this.timeRepository = timeRepository;
	}

	@Override
	public Optional<Time> buscaTimePorCampo(TimeForm form) {
		return timeRepository.findByNome(form.getNome());
	}

	@Override
	public String getCampoInvalido() {
		return "nome";
	}

}
