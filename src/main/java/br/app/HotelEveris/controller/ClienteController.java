package br.app.HotelEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.HotelEveris.request.ClienteRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.service.ClienteService;

@RestController
@RequestMapping("/clientes")

public class ClienteController extends BaseController {

	@Autowired
	ClienteService service;

	// POST - CRIAR UM CLIENTE
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ClienteRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {

			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER POR ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
