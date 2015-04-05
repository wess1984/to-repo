package domain;


import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vol
 *
 */
@Entity
public class Vol extends Produit implements Serializable {

	private String numeroVol;
	private Aeroport depart;
	private Aeroport arrivee;
	private Date dateDepart;
	private Date dateArrivee;
	private Avion avion;
	private List<Place> places;
	
	private static final long serialVersionUID = 1L;

	public Vol() {
		super();
	}   
	
	
	public Vol(String numeroVol, Aeroport depart, Aeroport arrivee,
			Date dateDepart, Date dateArrivee, Avion avion, List<Place> places) {
		super();
		this.numeroVol = numeroVol;
		this.depart = depart;
		this.arrivee = arrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.avion = avion;
		this.places = places;
	}


	public String getNumeroVol() {
		return this.numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

	
	@ManyToOne
	public Avion getAvion() {
		return avion;
	}


	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	public List<Place> getPlaces() {
		return places;
	}


	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	@OneToOne
	public Aeroport getDepart() {
		return depart;
	}


	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	@OneToOne
	public Aeroport getArrivee() {
		return arrivee;
	}


	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}



	public Date getDateDepart() {
		return dateDepart;
	}



	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}



	public Date getDateArrivee() {
		return dateArrivee;
	}



	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	
}
