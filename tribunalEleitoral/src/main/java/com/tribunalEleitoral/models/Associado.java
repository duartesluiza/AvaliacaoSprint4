package com.tribunalEleitoral.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name="TB_ASSOCIADO")
@NotNull
@Entity
public class Associado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String cargo;
	@Column
	private LocalDate dataNascimento;
	@Column
	private String sexo;
	
	
	public Associado() {
		
	}
	
	
	
	public Associado(String nome, String cargo, LocalDate dataNascimento, String sexo) {
		this.nome = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	
	
}
