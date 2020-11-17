package br.app.HotelEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.HotelEveris.model.TipoQuarto;

@Repository
public interface TipoQuartoRepository extends JpaRepository <TipoQuarto, Long>{
}
