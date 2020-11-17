package br.app.HotelEveris.response;

import java.util.List;

import br.app.HotelEveris.model.Comodidade;

public class ComodidadeListResponse  extends BaseResponse {

	private List<Comodidade> comodidade;

	public List<Comodidade> getComodidade() {
		return comodidade;
	}

	public void setComodidade(List<Comodidade> comodidade) {
		this.comodidade = comodidade;
	}

}
