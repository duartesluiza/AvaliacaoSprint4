package com.tribunalEleitoral.controllers.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.tribunalEleitoral.models.Associado;

public class AssociadoDto {

	private Long id;
	private String nome;
	private String cargo;
	private LocalDate dataNascimento;
	private String sexo;

	public AssociadoDto(Associado associado) {

		this.id = associado.getId();
		this.nome = associado.getNome();
		this.cargo = associado.getCargo();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public static List<AssociadoDto> converter(List<Associado> associados) {
		return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());

	}
}
