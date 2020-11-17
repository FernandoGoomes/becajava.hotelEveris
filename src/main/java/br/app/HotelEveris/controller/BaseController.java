package br.app.HotelEveris.controller;

import br.app.HotelEveris.response.BaseResponse;

public class BaseController  {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.message = "Erro inesperado";
		errorBase.statusCode = 500;
	}
}
