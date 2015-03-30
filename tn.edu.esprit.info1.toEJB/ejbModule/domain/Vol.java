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
	private String departAeroport;
	private String arriveeAeroport;
	private Integer capacite;
	private static final long serialVersionUID = 1L;

	public Vol() {
		super();
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
	public String getDepartAeroport() {
		return this.departAeroport;
	}

	public void setDepartAeroport(String departAeroport) {
		this.departAeroport = departAeroport;
	}   
	public String getArriveeAeroport() {
		return this.arriveeAeroport;
	}

	public void setArriveeAeroport(String arriveeAeroport) {
		this.arriveeAeroport = arriveeAeroport;
	}   
	public Integer getCapacite() {
		return this.capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
   
}
