package br.app.HotelEveris.service;

import br.app.HotelEveris.request.OcupacaoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.OcupacaoListResponse;

public interface OcupacaoService {
	BaseResponse inserir(OcupacaoRequest request);
	
	OcupacaoListResponse listar();
	
	

}
