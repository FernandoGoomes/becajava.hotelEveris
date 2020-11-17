package br.app.HotelEveris.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int andar;
	private int nquarto;
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "Idtipoquarto")
	private TipoQuarto tipoquarto;

	public Quarto() {

	}

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	public Quarto(int andar, int nquarto, String situacao, TipoQuarto tipoquarto) {

		this.andar = andar;
		this.nquarto = nquarto;
		this.situacao = situacao;
		this.tipoquarto = tipoquarto;
	}

	public int getNquarto() {
		return nquarto;
	}

	public void setNquarto(int nquarto) {
		this.nquarto = nquarto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoQuarto getTipoquarto() {
		return tipoquarto;
	}

	public void setTipoquarto(TipoQuarto tipoquarto) {
		this.tipoquarto = tipoquarto;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
