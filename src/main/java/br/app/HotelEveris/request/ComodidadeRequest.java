package br.app.HotelEveris.request;

public class ComodidadeRequest {

	private Long id;

	private String nome;
	


	public ComodidadeRequest() {

	}

	public ComodidadeRequest(String nome) {

		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
