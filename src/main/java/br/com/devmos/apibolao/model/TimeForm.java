package br.com.devmos.apibolao.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class TimeForm {
	
	@NotNull
	private String nome;
	
	@Past
	private LocalDate dataFundacao;

	public Time novo() {
		return new Time(nome, dataFundacao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
}
