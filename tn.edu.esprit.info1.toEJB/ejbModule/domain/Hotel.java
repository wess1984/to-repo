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
	private String categorie; // 2**, 3***
	private static final long serialVersionUID = 1L;
	
	private List<CategorieChambreProduit> categorieChambreProduits;

	public Hotel() {
		super();
	}   
	
	
	public Hotel(String code, String libelle, String ville, String categorie,List<CategorieChambreProduit> categorieChambreProduits){
		super();
		this.code = code;
		this.libelle = libelle;
		this.ville = ville;
		this.categorie = categorie;
		this.categorieChambreProduits=categorieChambreProduits;
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


	@OneToMany(mappedBy="produit")
	public List<CategorieChambreProduit> getCategorieChambreProduits() {
		return categorieChambreProduits;
	}


	public void setCategorieChambreProduits(List<CategorieChambreProduit> categorieChambreProduits) {
		this.categorieChambreProduits = categorieChambreProduits;
	}


	@Override
	public String toString() {
		return "Hotel [code=" + code + ", libelle=" + libelle + ", ville="
				+ ville + ", categorie=" + categorie
				+ ", categorieChambreProduits=" + categorieChambreProduits
				+ "]";
	}
	
	
   
}
