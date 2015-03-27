package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chambre
 *
 */
@Entity

public class Chambre implements Serializable {

	
	public Chambre(String type, Integer capacite) {
		super();
		
		this.type = type;
		this.capacite = capacite;
	}

	private Integer numeroChambre;
	private String type;
	private Integer capacite;

	private static final long serialVersionUID = 1L;

	public Chambre() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getNumeroChambre() {
		return this.numeroChambre;
	}

	public void setNumeroChambre(Integer numeroChambre) {
		this.numeroChambre = numeroChambre;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public Integer getCapacite() {
		return this.capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
   
}
