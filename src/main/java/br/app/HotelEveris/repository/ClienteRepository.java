package br.app.HotelEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.HotelEveris.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

