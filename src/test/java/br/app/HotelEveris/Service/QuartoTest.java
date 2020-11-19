package br.app.HotelEveris.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.request.ComodidadeRequest;
import br.app.HotelEveris.request.QuartoRequest;
import br.app.HotelEveris.request.SituacaoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.QuartoListResponse;
import br.app.HotelEveris.response.QuartoResponse;
import br.app.HotelEveris.service.QuartoService;

@SpringBootTest
public class QuartoTest {

	@Autowired
	private QuartoService service;

	public int pegarNumeroRandomico(int min, int max) {
		Random random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}

	@Test
	public void criarQuarto() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(8);
		request.setIdTipoquarto(1L);

		request.setSituacao("A");
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNquarto(nq);

		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest obj = new ComodidadeRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidade(comodidades);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.statusCode);

		Assertions.assertEquals("Quarto obtido", response.message);

	}

	@Test
	public void criarAtualizacao() {

		// SituacaoQuartoRequest request = new SituacaoQuartoRequest();

		SituacaoQuartoRequest request = new SituacaoQuartoRequest();
		request.setSituacao("I");

		Long id = 5l;
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Situação Atulizada Com sucesso", response.message);

	}

	@Test
	public void criarAtualizacaoerro() {

		// SituacaoQuartoRequest request = new SituacaoQuartoRequest();

		SituacaoQuartoRequest request = new SituacaoQuartoRequest();
		request.setSituacao("");

		Long id = 5l;
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("Situação do quarto não pode ser vazia", response.message);

	}

	@Test
	public void criarAtualizacaoerroUpdate() {

		

		SituacaoQuartoRequest request = new SituacaoQuartoRequest();
		request.setSituacao("S");

		Long id = -5l;
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(400, response.statusCode);
		Assertions.assertEquals("id nao encontrado tente novamente", response.message);
		
}
	

	
	@Test
	public void obter(){
		
		
		Long id = 2L;
		QuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Quarto obtidos com sucesso", response.message );
		
	}
	
	@Test
	public void obterlista() {
		
		Long id = 2L;
		
	QuartoListResponse response = service.obterlista(id);
		

		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Lista Obtida", response.message);
		
		
	}
//	
	
	
	
	
	
	
	
	
	
	

}
