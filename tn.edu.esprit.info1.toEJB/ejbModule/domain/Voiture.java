package domain;

import domain.Produit;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Voiture
 *
 */
@Entity

public class Voiture extends Produit implements Serializable {

	
	private String immatriculation;
	private String constructeur;
	private String Modele;
	private Integer nombrePlace;
	private String couleur;
	private static final long serialVersionUID = 1L;

	public Voiture() {
		super();
	}   
	public String getImmatriculation() {
		return this.immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}   
	public String getConstructeur() {
		return this.constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}   
	public String getModele() {
		return this.Modele;
	}

	public void setModele(String Modele) {
		this.Modele = Modele;
	}   
	public Integer getNombrePlace() {
		return this.nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}   
	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
   
}
