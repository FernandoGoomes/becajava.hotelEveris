package br.app.HotelEveris.response;

import br.app.HotelEveris.model.Comodidade;

public class QuartoComodidadeResponse {

	private String nome;
	private Comodidade comodidade;
	private Long id;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Comodidade getComodidade() {
		return comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
