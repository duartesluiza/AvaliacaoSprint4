package com.tribunalEleitoral.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NotNull
@Entity
//@Table(name="TB_PARTIDO")
public class Partido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	@Column
	private String sigla;
	@Column
	private String ideologia;
	@Column
	private LocalDate dataFundacao;
	
	
	public Partido() {
		
	}
	
	
	
	
	public Partido(String nome, String sigla, String ideologia, LocalDate dataFundacao) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
	
	
	
}
