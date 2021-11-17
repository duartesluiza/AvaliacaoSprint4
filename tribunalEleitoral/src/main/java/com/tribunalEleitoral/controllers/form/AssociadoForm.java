package com.tribunalEleitoral.controllers.form;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.tribunalEleitoral.models.Associado;
import com.tribunalEleitoral.repository.AssociadoRepository;

@Valid
public class AssociadoForm {
	

	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
	
//	@Pattern(regexp = "Vereador|Prefeito|Deputado Estadual|Deputado Federal|Senador|Governador|Presidente|Nenhum",
//	        message="Cargos permitidos: Vereador,Prefeito,Deputado Estadual,Deputado Federal,Senador,Governador,Presidente e Nenhum")
	@NotNull @NotEmpty @Length(min = 2)
	private String cargo;
	@NotNull @NotEmpty
	private LocalDate dataNascimento;
	
//	@Pattern(regexp = "Masculino|Feminino",
//	        message="Só sao permitidos os valores Masculino ou Feminino")
	@NotNull @NotEmpty @Length(min = 2)
	private String sexo;
	
	
	
	

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
	
	
	public Associado converter(AssociadoRepository associadoRepository) {
		List<Associado> associado = associadoRepository.findBySexo(sexo);
		return new Associado(nome, cargo, dataNascimento, sexo);
	}
	
	
	public Associado atualizar(Long id, AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.getOne(id);
		
		associado.setNome(this.nome);
		associado.setCargo(this.cargo);
		associado.setDataNascimento(this.dataNascimento);
		associado.setSexo(this.sexo);
		
		
		return associado;
	}

	
	
}
