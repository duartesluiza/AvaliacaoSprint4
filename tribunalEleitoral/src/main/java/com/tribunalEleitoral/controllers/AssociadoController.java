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

import com.tribunalEleitoral.controllers.dto.AssociadoDto;
import com.tribunalEleitoral.controllers.form.AssociadoForm;
import com.tribunalEleitoral.models.Associado;
import com.tribunalEleitoral.repository.AssociadoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST TribunalEleitoral")
@CrossOrigin(origins="*")
public class AssociadoController {
	
	
	//INJEÇÃO
		@Autowired
		private AssociadoRepository associadoRepository;
		
		
		@GetMapping("/associados")
		@ApiOperation(value="Retorna uma lista de associados")
		public List<Associado> listaAssociados() {
			return associadoRepository.findAll();
		}
		
		@GetMapping("/associado/{id}")
		@ApiOperation(value="Retorna um associado único por id")
		public Optional<Associado> listaAssociadoUnico(@PathVariable(value="id") long id) {
			return associadoRepository.findById(id);
		}

		@PostMapping("/associado")
		@Transactional
		@ApiOperation(value="Salva um associado")
		public Associado salvaAssociado(@RequestBody Associado associado) {
			return associadoRepository.save(associado);
		}
		
		@DeleteMapping("/associado")
		@ApiOperation(value="Deleta um associado por id")
		public void deletaAssociado(@RequestBody Associado associado) {
			associadoRepository.delete(associado);
		}
		
		@PutMapping("/associado")
		@Transactional
		@ApiOperation(value="Atualiza um associado")
		public Associado atualizaAssociado(@RequestBody Associado associado) {
			return associadoRepository.save(associado);
		}
		
		
		
		@GetMapping("/associados/sexo")
		@ApiOperation(value="Filtra uma lista de associados por sexo")
		public ResponseAssociado lista(String sexo) {

			System.out.println("Parametro recebido: "+ sexo);
			ResponseAssociado responseAssociados;
			if (sexo == null) {
				List<Associado> associados = associadoRepository.findAll();
				responseAssociados = new ResponseAssociado("Sucesso!", AssociadoDto.converter(associados));
				System.out.println("Parametro recebido: "+ sexo);
				
				return responseAssociados;

			} else if (validaSexo(sexo)) {
				List<Associado> associados = associadoRepository.findBySexo(sexo);

				responseAssociados = new ResponseAssociado("Sucesso!", AssociadoDto.converter(associados));

				return responseAssociados;
			}

			responseAssociados = new ResponseAssociado("Parâmetro inválido! Só são permitidos os valores Masculino ou Feminino", null);
			return responseAssociados;

		}

		private boolean validaSexo(String sexo) {
			System.out.println(sexo);
			if (sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) {
				return true;

			}
	
			return false;
		}
}
