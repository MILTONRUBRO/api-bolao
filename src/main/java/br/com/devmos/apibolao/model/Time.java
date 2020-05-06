package br.com.devmos.apibolao.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private LocalDate dataFundacao;
	
	@Deprecated
	public Time() {
		
	}
	
	public Time(@NotNull String nome, @Past LocalDate dataFundacao) {
		this.nome = nome;
		this.dataFundacao = dataFundacao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
}
