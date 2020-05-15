package br.com.devmos.apibolao.model;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;


public class CampeonatoForm {
	
	@NotNull
	private String nome;
	
	@FutureOrPresent
	private LocalDate dataComeco;
	
	@NotNull
	private Integer numeroTimes;

	public Campeonato novo() {
		return new Campeonato(nome, dataComeco, numeroTimes);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(LocalDate dataComeco) {
		this.dataComeco = dataComeco;
	}

	public Integer getNumeroTimes() {
		return numeroTimes;
	}

	public void setNumeroTimes(Integer numeroTimes) {
		this.numeroTimes = numeroTimes;
	}
	

}
