package br.com.devmos.apibolao.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class Campeonato {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@FutureOrPresent
	private LocalDate dataComeco;
	
	@NotNull
	private Integer numeroTimes;
	
	@Deprecated
	public Campeonato(){
		
	}
	
	public Campeonato(@NotNull String nome, @FutureOrPresent LocalDate dataComeco, @NotNull Integer numeroTimes) {
		this.nome = nome;
		this.dataComeco = dataComeco;
		this.numeroTimes = numeroTimes;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataComeco() {
		return dataComeco;
	}

	public Integer getNumeroTimes() {
		return numeroTimes;
	}
	
}
