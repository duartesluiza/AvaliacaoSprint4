package com.tribunalEleitoral.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribunalEleitoral.controllers.dto.PartidoDto;
import com.tribunalEleitoral.models.Partido;
import com.tribunalEleitoral.repository.PartidoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Essa classe vai receber minhas requisições HTTP

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST TribunalEleitoral")
@CrossOrigin(origins="*")

public class PartidoController {
	
	//INJEÇÃO
	@Autowired
	private PartidoRepository partidoRepository;
	
	
	@GetMapping("/partidos")
	@ApiOperation(value="Retorna uma lista de partidos")
	public List<Partido> listaPartidos() {
		return partidoRepository.findAll();
	}
	
	
	@GetMapping("/partido/{id}")
	@ApiOperation(value="Retorna um partido único por id")
	public Optional<Partido> listaPartidoUnico(@PathVariable(value="id") Long id) {
		return partidoRepository.findById(id);
	}
	
	
	@PostMapping("/partido")
	@Transactional
	@ApiOperation(value="Salva um partido")
	public Partido salvaPartido(@RequestBody Partido partido) {
		return partidoRepository.save(partido);
	}

	
	@DeleteMapping("/partido")
	@ApiOperation(value="Deleta um partido por id")
	public void deletaPartido(@RequestBody Partido partido) {
		partidoRepository.delete(partido);
	}
	
	
	@PutMapping("/partido")
	@Transactional
	@ApiOperation(value="Atualiza um partido")
	public Partido atualizaPartido(@RequestBody Partido partido) {
		return partidoRepository.save(partido);
		
	}

	
	

	
	@GetMapping("/partidos/ideologia")
	@ApiOperation(value="Retorna uma lista de partido por ideologia")
	public ResponsePartido lista(String ideologia) {

		System.out.println("Parametro recebido: "+ ideologia);
		ResponsePartido responsePartidos;
		if (ideologia == null) {
			List<Partido> partidos = partidoRepository.findAll();
			responsePartidos = new ResponsePartido("Sucesso!", PartidoDto.converter(partidos));
			System.out.println("Parametro recebido: "+ ideologia);
			
			return responsePartidos;

		} else if (validaIdeologia(ideologia)) {
			List<Partido> partidos = partidoRepository.findByIdeologia(ideologia);

			responsePartidos = new ResponsePartido("Sucesso!", PartidoDto.converter(partidos));

			return responsePartidos;
		}

		responsePartidos = new ResponsePartido("Parâmetro inválido!", null);
		return responsePartidos;

	}
	
	private boolean validaIdeologia(String ideologia) {
		System.out.println(ideologia);
		if (ideologia.equalsIgnoreCase("Direita") || ideologia.equalsIgnoreCase("Esquerda") 
				|| ideologia.equalsIgnoreCase("Centro")) {
			return true;

		}
	return false;
}
	
	
	

		
	}
	

