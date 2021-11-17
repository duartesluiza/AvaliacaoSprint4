package com.tribunalEleitoral.controllers;

import java.util.List;

import com.tribunalEleitoral.controllers.dto.PartidoDto;

public class ResponsePartido {
	
	private String mensagem;
	private List<PartidoDto> partidos;
	
	
	
	public ResponsePartido(String mensagem, List<PartidoDto> partidos) {
		this.mensagem = mensagem;
		this.partidos = partidos;
	}
	
	public ResponsePartido() {

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<PartidoDto> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<PartidoDto> partidos) {
		this.partidos = partidos;
	}
	
	
	

}
