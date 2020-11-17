package br.app.HotelEveris.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.request.ComidadeRequestDoInserir;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ComodidadeResponse;
import br.app.HotelEveris.service.ComodidadeService;

@SpringBootTest
public class ComodidadeTest {

	@Autowired
	private ComodidadeService service;

	@Test
	void inserir() {
		ComidadeRequestDoInserir request = new ComidadeRequestDoInserir();
		request.setNome("Banheira");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.statusCode);
		Assertions.assertEquals("Comodidade feito", response.message);
	}

	@Test
	void inserirSemNome() {
		ComidadeRequestDoInserir request = new ComidadeRequestDoInserir();
		request.setNome("");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("A comodidade não pode ser vazia", response.message);

	}

	@Test
	void obterComodidadeporid() {
	ComodidadeResponse response = new ComodidadeResponse();
	
	 
		Long id = 3L;
	
	service.obter(id);

		Assertions.assertEquals(201, response.statusCode);
		Assertions.assertEquals("Descricao vazia tente novamente", response.message);

	}
	
	
	@Test
	void naoobterComodidadeporid() {
		
	ComodidadeResponse response = new ComodidadeResponse();
	
		 service.obter(50L);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("Id não encontrado.", response.message);

	}
	
	
	

}