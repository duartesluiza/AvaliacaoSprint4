package com.tribunalEleitoral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tribunalEleitoral.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

	List<Partido> findAll();
	
//	Partido findById(long id);

	List<Partido> findByIdeologia(String ideologia);

}
