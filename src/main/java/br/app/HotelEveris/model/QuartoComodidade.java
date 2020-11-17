package br.app.HotelEveris.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuartoComodidade {
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "IdQuarto")
	private Quarto quarto;

	@ManyToOne
	@JoinColumn(name = "IdComodidade")
	private Comodidade comodidade;
	
	public QuartoComodidade() {
		
		
	}

	public QuartoComodidade(Long id) {
		super();
		this.id = id;
	}



	public QuartoComodidade( Quarto quarto, Comodidade comodidade) {
		super();

		this.quarto = quarto;
		this.comodidade = comodidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Comodidade getComodidade() {
		return comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}

}
