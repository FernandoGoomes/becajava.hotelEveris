package br.app.HotelEveris.service;


import br.app.HotelEveris.request.ClienteRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ClienteResponse;

public interface ClienteService {
	public BaseResponse criar(ClienteRequest request);
	
	public ClienteResponse obter(Long id);

	}