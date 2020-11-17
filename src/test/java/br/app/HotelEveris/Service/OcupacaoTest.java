package br.app.HotelEveris.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.request.OcupacaoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.OcupacaoListResponse;
import br.app.HotelEveris.service.OcupacaoService;

@SpringBootTest
public class OcupacaoTest {
	@Autowired
	private OcupacaoService service;

	@Test
	void inserirOcupacaoinserir() {

		OcupacaoRequest request = new OcupacaoRequest();
		
	


		request.setData("18-18-2019");
		request.setQtdiarias(2);
		request.setIdquarto(2l);;
		request.setIdcliente(1l);

		request.setSituacao("N");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.statusCode);
		Assertions.assertEquals("Ocupacao Inserida.", response.message);

	}

	@Test
	void inserirOcupacaoinserirerro() {

		OcupacaoRequest request = new OcupacaoRequest();

		request.setData("");
		request.setIdcliente(1l);
		request.setIdquarto(1l);
		request.setQtdiarias(2);
		request.setSituacao("N");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira uma data", response.message);

	}

	
	@Test
	void inserirOcupacaoinserirerrop1() {

		OcupacaoRequest request = new OcupacaoRequest();

		request.setData("10/20/20");
		request.setIdcliente(60l);
		request.setIdquarto(1l);
		request.setQtdiarias(2);
		request.setSituacao("N");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira um id de cliente existente", response.message);

	}

	@Test
	void inserirOcupacaoinserirerrop2() {

		OcupacaoRequest request = new OcupacaoRequest();

		request.setData("10/20/20");
		request.setIdcliente(1l);
		request.setIdquarto(40l);
		request.setQtdiarias(2);
		request.setSituacao("N");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira um id de quarto existente", response.message);

	}
	
	
	@Test
	void obterlistageral(){
         
		OcupacaoListResponse response = new OcupacaoListResponse();
		
         
		
		  response.setOcupacao(response.getOcupacao());
		
		
		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Serviços obtidos com sucesso.", response.message);
		
		
}

	
}
