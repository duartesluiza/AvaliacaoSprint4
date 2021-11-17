package com.tribunalEleitoral.controllers;

import java.util.List;

import com.tribunalEleitoral.controllers.dto.AssociadoDto;

public class ResponseAssociado {

	private String mensagem;
	private List<AssociadoDto> associados;
	
	
	public ResponseAssociado(String mensagem, List<AssociadoDto> associados) {
		this.mensagem = mensagem;
		this.associados = associados;
	}
	
	ResponseAssociado() {
		
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<AssociadoDto> getAssociados() {
		return associados;
	}

	public void setAssociados(List<AssociadoDto> associados) {
		this.associados = associados;
	}
	
	
	
}
