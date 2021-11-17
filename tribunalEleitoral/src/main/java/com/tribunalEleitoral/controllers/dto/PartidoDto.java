package com.tribunalEleitoral.controllers.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.tribunalEleitoral.models.Partido;

public class PartidoDto {

	private Long id;
	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDate dataFundacao;

	public PartidoDto(Partido partido) {

		this.id = partido.getId();
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.ideologia = partido.getIdeologia();
		this.dataFundacao = partido.getDataFundacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public static List<PartidoDto> converter(List<Partido> partidos) {
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());

	}
}
