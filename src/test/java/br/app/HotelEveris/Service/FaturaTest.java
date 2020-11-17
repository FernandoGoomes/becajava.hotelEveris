package br.app.HotelEveris.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.service.FaturaService;

@SpringBootTest
public class FaturaTest {

	@Autowired
	private FaturaService service;

	@Test
	public void Transferencia() {
		BaseResponse response = service.inserir();

		Assertions.assertEquals(200, response.statusCode);
		Assertions.assertEquals("Transferencia completa", response.message);

	}

}
