package br.com.devmos.apibolao.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apibolao.model.Time;
import br.com.devmos.apibolao.model.TimeDTO;
import br.com.devmos.apibolao.model.TimeForm;
import br.com.devmos.apibolao.repository.TimeRepository;
import br.com.devmos.apibolao.validator.EmailUnicoUsuarioValidator;
import br.com.devmos.apibolao.validator.NomeUnicoTimeValidator;

@RestController
public class TimeController {
	
	@Autowired
	private TimeRepository timeRepository;
	
	@InitBinder("timeForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new NomeUnicoTimeValidator(timeRepository));
	}
	
	@PostMapping(value="api/time")
	@Transactional
	public void adicionar(@Valid @RequestBody TimeForm form) {
		
		Time time = form.novo();
		
		timeRepository.save(time);
		
	}
	
	@GetMapping(value="api/time/{idTime}")
	public ResponseEntity<TimeDTO> getTime(@PathVariable("idTime") Long idTime){
		
		Optional<Time> possivelTime = timeRepository.findById(idTime);
		
		if(possivelTime.isPresent()) {
			return ResponseEntity.ok(new TimeDTO(possivelTime.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping(value="api/times")
	public List<TimeDTO> getTimes(){
		List<Time> times = timeRepository.findAll();
		
		return TimeDTO.converter(times);
	}

}
