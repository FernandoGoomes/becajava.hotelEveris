package br.app.HotelEveris.request;

import java.util.List;

import br.app.HotelEveris.model.Comodidade;
import br.app.HotelEveris.model.Quarto;
import br.app.HotelEveris.model.TipoQuarto;

public class QuartoRequest {
	private int andar;
	private int nquarto;
	private String situacao;
	private Long idTipoquarto;

	private List<ComodidadeRequest> Comodidade;

	public void setComodidade(List<ComodidadeRequest> comodidade) {
		Comodidade = comodidade;
	}

	public void setNquarto(int nquarto) {
		this.nquarto = nquarto;
	}

	public List<ComodidadeRequest> getComodidade() {
		return Comodidade;
	}

	

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNquarto() {
		return nquarto;
	}

	public Long getIdTipoquarto() {
		return idTipoquarto;
	}

	public void setIdTipoquarto(Long idTipoquarto) {
		this.idTipoquarto = idTipoquarto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	
	
	

}
