package br.app.HotelEveris.response;

import java.util.List;

import br.app.HotelEveris.model.Quarto;
import br.app.HotelEveris.model.TipoQuarto;

public class QuartoListResponse extends BaseResponse{
	
	
	
	
	private List <Quarto> quarto ;

	public List<Quarto> getQuarto() {
		return quarto;
	}

	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}
	
	
	
	
	

}
