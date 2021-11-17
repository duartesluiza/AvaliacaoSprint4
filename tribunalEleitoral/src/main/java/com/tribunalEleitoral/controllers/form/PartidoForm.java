package com.tribunalEleitoral.controllers.form;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.tribunalEleitoral.models.Partido;
import com.tribunalEleitoral.repository.PartidoRepository;


@Valid
public class PartidoForm {
	
	
		
	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
	@NotNull @NotEmpty @Length(min = 1)
	private String sigla;
	@NotNull @NotEmpty @Length(min = 2)
	private String ideologia;
	@NotNull @NotEmpty
	private LocalDate dataFundacao;
	
	
	
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getIdeologia() {
		return ideologia;
	}
	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
	

	public Partido converter(PartidoRepository partidoRepository) {
		List<Partido> partido = partidoRepository.findByIdeologia(ideologia);
		return new Partido(nome, sigla, ideologia, dataFundacao);
	}


	
	public Partido atualizar(Long id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);
		
		partido.setNome(this.nome);
		partido.setSigla(this.sigla);
		partido.setIdeologia(this.ideologia);
		partido.setDataFundacao(this.dataFundacao);
		
		
		return partido;
	}
	

}
