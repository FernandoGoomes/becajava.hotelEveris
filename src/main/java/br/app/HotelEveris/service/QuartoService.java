package br.app.HotelEveris.service;

import br.app.HotelEveris.request.QuartoRequest;
import br.app.HotelEveris.request.SituacaoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.QuartoListResponse;
import br.app.HotelEveris.response.QuartoResponse;

public interface QuartoService {
	
	BaseResponse inserir(QuartoRequest request);
	
	QuartoResponse obter(Long id);
	
	QuartoListResponse obterlista(Long id);
	
	BaseResponse atualizar(Long id, SituacaoQuartoRequest request);
	
	
}
