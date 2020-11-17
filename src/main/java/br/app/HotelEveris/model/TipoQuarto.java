package br.app.HotelEveris.model;

import javax.persistence.*;

@Entity
public class TipoQuarto {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String descricao;
	private double valor;
	
	
	



	public TipoQuarto() {
		super();
	}

	public TipoQuarto(Long id) {

		this.id = id;
	}

	public TipoQuarto(String descricao, double valor) {

		this.descricao = descricao;
		this.valor = valor;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}