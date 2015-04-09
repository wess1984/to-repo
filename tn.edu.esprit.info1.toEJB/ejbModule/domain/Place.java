package domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.String;

import javax.persistence.*;

import utils.Emplacement;
import utils.TypePlace;

/**
 * Entity implementation class for Entity: Place
 *
 */
@Entity

public class Place implements Serializable {

	private Integer id;
	private String reference;
	private TypePlace type; // Economique | Business
	private Emplacement emplacement; // coté fenetre
	private Boolean estReserve;
	private Float prix;
	private Float remise;
	private static final long serialVersionUID = 1L;

	public Place() {
		super();
	}   
	
	public Place(String reference, TypePlace type, Emplacement emplacement, Boolean estReserve, Float prix,
			Float remise) {
		super();
		this.reference = reference;
		this.type = type;
		this.emplacement = emplacement;
		this.estReserve = estReserve;
		this.prix = prix;
		this.remise = remise;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	    
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}   
	public TypePlace getType() {
		return this.type;
	}

	public void setType(TypePlace type) {
		this.type = type;
	}   
	public Boolean getEstReserve() {
		return this.estReserve;
	}

	public void setEstReserve(Boolean estReserve) {
		this.estReserve = estReserve;
	}   
	public Float getPrix() {
		return this.prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}   
	public Float getRemise() {
		return this.remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}
   
}
