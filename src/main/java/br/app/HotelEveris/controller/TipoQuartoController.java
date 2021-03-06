package br.app.HotelEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.app.HotelEveris.request.TipoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.service.TipoQuartoService;

@RestController
@RequestMapping("/tipoquarto")
public class TipoQuartoController  extends BaseController{

	

		@Autowired
		TipoQuartoService _service;


		@PostMapping
		public ResponseEntity<BaseResponse> criar(@RequestBody TipoQuartoRequest request) { 
			try {
				BaseResponse response = _service.criar(request);
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}
		@GetMapping(path = "/{id}")
		public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
			try {
				BaseResponse response = _service.obter(id);
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}

		@GetMapping
		public ResponseEntity<BaseResponse> listar() {
			try {
				BaseResponse response = _service.listar();
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}

}
