package br.com.devmos.apibolao.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apibolao.model.Campeonato;
import br.com.devmos.apibolao.model.CampeonatoForm;
import br.com.devmos.apibolao.repository.CampeonatoRepository;
import br.com.devmos.apibolao.validator.NomeUnicoCampeonatoValidator;
import br.com.devmos.apibolao.validator.NomeUnicoTimeValidator;

@RestController
public class CampeonatoController {
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@InitBinder("campeonatoForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new NomeUnicoCampeonatoValidator(campeonatoRepository));
	}
	
	@PostMapping(value="api/campeonato")
	@Transactional
	public void adicionar(@Valid @RequestBody CampeonatoForm form){
		
		Campeonato campeonato = form.novo();
		campeonatoRepository.save(campeonato);
		
	}

}
