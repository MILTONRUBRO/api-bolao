package br.com.devmos.apibolao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apibolao.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{
	
	Optional<Time> findByNome(String nome);

}
