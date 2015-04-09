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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime
				* result
				+ ((categorieChambreProduits == null) ? 0
						: categorieChambreProduits.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (categorieChambreProduits == null) {
			if (other.categorieChambreProduits != null)
				return false;
		} else if (!categorieChambreProduits
				.equals(other.categorieChambreProduits))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	
	
   
}
