package br.app.HotelEveris.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.app.HotelEveris.model.Comodidade;


@Repository
public interface ComodidadeRepository extends JpaRepository<Comodidade, Long>{
	

	   

}
