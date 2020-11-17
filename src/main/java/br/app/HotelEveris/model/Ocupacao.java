package br.app.HotelEveris.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ocupacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String data;

	private String situacao;

	private int qtdiarias;

	@ManyToOne
	@JoinColumn(name = "Idquarto")
	private Quarto quarto;

	@ManyToOne
	@JoinColumn(name = "Idcliente")
	private Cliente cliente;

	public Ocupacao() {

	}

	public int getQtdiarias() {
		return qtdiarias;
	}

	public void setQtdiarias(int qtdiarias) {
		this.qtdiarias = qtdiarias;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
