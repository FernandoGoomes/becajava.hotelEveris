package br.app.HotelEveris.request;





public class OcupacaoRequest {

	private Long idquarto;
	private String data;
	private int qtdiarias;
	private Long idcliente;
	private String situacao;
	
	
	
	
	

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Long getIdquarto() {
		return idquarto;
	}

	public void setIdquarto(Long idquarto) {
		this.idquarto = idquarto;
	}

	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdiarias() {
		return qtdiarias;
	}

	public void setQtdiarias(int qtdiarias) {
		this.qtdiarias = qtdiarias;
	}

}
