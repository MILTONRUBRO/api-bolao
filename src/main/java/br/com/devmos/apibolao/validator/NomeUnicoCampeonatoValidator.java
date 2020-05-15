package br.com.devmos.apibolao.validator;

import java.util.Optional;

import br.com.devmos.apibolao.model.Campeonato;
import br.com.devmos.apibolao.model.CampeonatoForm;
import br.com.devmos.apibolao.repository.CampeonatoRepository;

public class NomeUnicoCampeonatoValidator extends CampoUnicoCampeonatoValidator{
	
	private CampeonatoRepository campeonatoRepository;
	
	public NomeUnicoCampeonatoValidator(CampeonatoRepository campeonatoRepository) {
		this.campeonatoRepository = campeonatoRepository;
	}

	@Override
	public Optional<Campeonato> buscaCampeonatoPorCampo(CampeonatoForm form) {
		return campeonatoRepository.findByNome(form.getNome());
	}

	@Override
	public String getCampoInvalido() {
		return "nome";
	}

}
