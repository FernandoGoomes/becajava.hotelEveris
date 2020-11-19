package br.app.HotelEveris.Service;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.request.ClienteRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ClienteResponse;
import br.app.HotelEveris.service.ClienteService;

@SpringBootTest
public class ClienteTest {

	@Autowired
	private ClienteService service;

	
	
	@Test
	void inserirClienteinserir() {

		ClienteRequest request = new ClienteRequest();

		request.setCpf("000");
		request.setNome("Freed");
		request.setHash("TE456DO");
		

		BaseResponse response = service.criar(request);

		Assertions.assertEquals(201, response.statusCode);
		Assertions.assertEquals("Cliente foi criado com sucesso", response.message);

	}
	
	


	@Test
	void inserirClienteNomeinserir() {

		ClienteRequest request = new ClienteRequest();

		request.setCpf("00000");
		request.setNome("");
		request.setHash("sdsdsdsds");

		BaseResponse response = service.criar(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira um nome  e tente novamente", response.message);

	}
	
	@Test
	void inserirClienteCpfnaoinserir() {

		ClienteRequest request = new ClienteRequest();

		request.setCpf("");
		request.setNome("Freed");
		request.setHash("sdsdsdsds");

		BaseResponse response = service.criar(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira um cpf e tente novamente", response.message);

	}
	
    @Test
	void inserirClienteHashnaoinserir() {

		ClienteRequest request = new ClienteRequest();

		request.setCpf("000.000.000.00");
		request.setNome("Freed");
		request.setHash("");

		BaseResponse response = service.criar(request);

		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("insira um hash e tente novamente", response.message);

	}
    
    @Test
	void obterClienteporid() {
	ClienteResponse response = new ClienteResponse();
	
		 service.obter(1L);

		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Conta obtida com sucesso.", response.message);

	}
    
    @Test
   	void obterClienteNaoIdentificadoporid() {
    	
   	ClienteResponse response = new ClienteResponse();
   	
   		 service.obter(50L);

   		Assertions.assertEquals(400, response.statusCode);
   		Assertions.assertEquals("Id inexistente tente novamente", response.message);

   	}
    
    
    
   	
	
    
    
    
    
	
	
	
	
	
	
	

}
