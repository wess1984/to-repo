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
	
	
	public Hotel(String code, String libelle, String ville, String categorie,
			List<Chambre> chambres) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.ville = ville;
		this.categorie = categorie;
		this.chambres = chambres;
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
	
	//@OneToMany
	@ManyToMany
	  @JoinTable(
	      name="HOTEL_CHAMBRE",
	      joinColumns={@JoinColumn(name="HOTEL_ID", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="CHAMBRE_ID", referencedColumnName="numeroChambre")})
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
   
}
