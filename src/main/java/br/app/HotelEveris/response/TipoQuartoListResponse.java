package br.app.HotelEveris.response;

import java.util.List;

import br.app.HotelEveris.model.TipoQuarto;

public class TipoQuartoListResponse  extends BaseResponse{

	private List<TipoQuarto> tipoquarto;

	public List<TipoQuarto> getTipoquarto() {
		return tipoquarto;
	}

	public void setTipoquarto(List<TipoQuarto> tipoquarto) {
		this.tipoquarto = tipoquarto;
	}

}
