package br.app.HotelEveris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.app.HotelEveris.model.QuartoComodidade;

@Repository
public interface QuartoComodidadeRepository extends JpaRepository<QuartoComodidade, Long> {

}
