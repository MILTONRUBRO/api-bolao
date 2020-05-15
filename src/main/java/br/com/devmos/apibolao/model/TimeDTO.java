package br.com.devmos.apibolao.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDTO {
	
	private String nome;
	private LocalDate dataFundacao;
	
	public TimeDTO(Time time) {
		this.nome = time.getNome();
		this.dataFundacao = time.getDataFundacao();
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

	public static List<TimeDTO> converter(List<Time> times) {
		return times.stream().map(TimeDTO::new).collect(Collectors.toList());
	}
	
}
