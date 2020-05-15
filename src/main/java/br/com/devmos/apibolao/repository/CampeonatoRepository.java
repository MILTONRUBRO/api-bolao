package br.com.devmos.apibolao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apibolao.model.Campeonato;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

	Optional<Campeonato> findByNome(String nome);

}
 