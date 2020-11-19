package br.app.HotelEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.HotelEveris.request.QuartoRequest;
import br.app.HotelEveris.request.SituacaoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.service.QuartoService;

@RestController
@RequestMapping("/quartos")

public class QuartoController extends BaseController {

	@Autowired
	QuartoService service;

	// POST - CRIAR UM CLIENTE
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}/obtermoreonce")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

	@GetMapping(path = "/{id}/obterdenovo")
	public ResponseEntity<BaseResponse> obterlista(@PathVariable Long id) {
		try {
			BaseResponse response = service.obterlista(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

	@PatchMapping("/{id}")

	public ResponseEntity<BaseResponse> atualizar(@Validated @PathVariable("id") Long id,
			@RequestBody SituacaoQuartoRequest request) {
		try {

			BaseResponse response = service.atualizar(id, request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {

			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

}
