package br.app.HotelEveris.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.request.TipoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.OcupacaoListResponse;
import br.app.HotelEveris.response.TipoQuartoListResponse;
import br.app.HotelEveris.response.TipoQuartoResponse;
import br.app.HotelEveris.service.TipoQuartoService;

@SpringBootTest
public class TipoQuartoTest {

	@Autowired
	private TipoQuartoService service;

	@Test
	void inserirTipoquarto() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setValor(120);
		request.setDescricao("Luxo");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.statusCode);
		Assertions.assertEquals("tipo de quarto inserido.", response.message);
	}

	@Test
	void inserirTipoquartoSemvalor() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setValor(0);
		request.setDescricao("Luxo");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("Valor incopartivel tente novamente", response.message);

	}

	
	@Test
	void inserirTipoQuartoDescricaovazia() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setValor(20);
		request.setDescricao("");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("Descricao vazia tente novamente", response.message);

	}
	

	@Test
	void obterTipoQuarto () {
         
		TipoQuartoResponse response = new  TipoQuartoResponse();
		 service.obter(2L);

		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Quarto obtidos com sucesso", response.message);
		
		
		
	}
	

	
	
	@Test
	void obterTipoQuartonumeroInexistente (){
         
		TipoQuartoResponse response = new  TipoQuartoResponse();
		 service.obter(50L);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("Id não encontrado tente novamente", response.message);
	}
	
	
	
	
	
	@Test
	void obterlistageral(){
         
		TipoQuartoListResponse response = new TipoQuartoListResponse();
		
		
		
		
		  response.setTipoquarto(response.getTipoquarto());
		
		
		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Serviços obtidos com sucesso.", response.message);
		
		
}
	
	@Test
    public void pegaLista() {
    OcupacaoListResponse obj = new OcupacaoListResponse();
    obj.setOcupacao(obj.getOcupacao());

    BaseResponse response = service.listar();
    
    
    
    Assertions.assertEquals(200,response.statusCode);
    
    
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
