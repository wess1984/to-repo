package domain;

import domain.Produit;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

public class Hotel extends Produit implements Serializable {

	
	private String code;
	private String libelle;
	private String ville;
	private String categorie;
	private static final long serialVersionUID = 1L;
	
	private List<Chambre> chambres;

	public Hotel() {
		super();
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}   
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}   
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	@OneToMany
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
   
}
