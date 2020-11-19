package br.app.HotelEveris.service;

import br.app.HotelEveris.request.TipoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.TipoQuartoListResponse;
import br.app.HotelEveris.response.TipoQuartoResponse;

public interface TipoQuartoService {
	
	BaseResponse criar(TipoQuartoRequest tipodequartoreq);
	
	TipoQuartoResponse obter(Long id);
	
	TipoQuartoListResponse listar();
	
	


}
