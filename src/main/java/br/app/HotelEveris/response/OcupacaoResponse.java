package br.app.HotelEveris.response;

import java.util.Date;

import br.app.HotelEveris.model.Cliente;
import br.app.HotelEveris.model.Quarto;

public class OcupacaoResponse extends BaseResponse {

	Long id;

	private String data;

	private String situacao;

	private int qtdiarias;

	private Quarto quarto;
	private Cliente cliente;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

}
