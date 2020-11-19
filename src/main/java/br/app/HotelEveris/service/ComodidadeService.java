package br.app.HotelEveris.service;

import br.app.HotelEveris.request.ComidadeRequestDoInserir;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ComodidadeResponse;

public interface ComodidadeService {
	
	BaseResponse inserir(ComidadeRequestDoInserir request);
	
	ComodidadeResponse obter(Long id);
	

}