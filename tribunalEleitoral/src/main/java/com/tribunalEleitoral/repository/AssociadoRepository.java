package com.tribunalEleitoral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tribunalEleitoral.models.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	List<Associado> findBySexo(String sexo);

}
