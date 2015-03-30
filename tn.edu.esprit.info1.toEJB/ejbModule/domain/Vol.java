package domain;

import domain.Produit;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vol
 *
 */
@Entity

public class Vol extends Produit implements Serializable {

	
	private String numeroVol;
	private Date dateDepart;
	private Date dateArrivee;
	private Aeroport departAeroport;
	private Aeroport arriveeAeroport;
	private Integer capacite;
	private static final long serialVersionUID = 1L;

	public Vol() {
		super();
	}   
	
	
	public Vol(String numeroVol, Date dateDepart, Date dateArrivee,
			Aeroport departAeroport, Aeroport arriveeAeroport, Integer capacite) {
		super();
		this.numeroVol = numeroVol;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.departAeroport = departAeroport;
		this.arriveeAeroport = arriveeAeroport;
		this.capacite = capacite;
	}


	public String getNumeroVol() {
		return this.numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}   
	
	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}   
	public Date getDateArrivee() {
		return this.dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}   
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public Aeroport getDepartAeroport() {
		return this.departAeroport;
	}

	public void setDepartAeroport(Aeroport departAeroport) {
		this.departAeroport = departAeroport;
	}   
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public Aeroport getArriveeAeroport() {
		return this.arriveeAeroport;
	}

	public void setArriveeAeroport(Aeroport arriveeAeroport) {
		this.arriveeAeroport = arriveeAeroport;
	}   
	public Integer getCapacite() {
		return this.capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
   
}
