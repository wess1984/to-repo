package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chambre
 *
 */
@Entity

public class CategorieChambre implements Serializable {
	
	private Integer id;
	private String libelle;
	
	private List<CategorieChambreProduit> categorieChambreProduits;
	
	public CategorieChambre(String libelle) {
		this.libelle = libelle;
	}

	private static final long serialVersionUID = 1L;

	public CategorieChambre() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(mappedBy="categorieChambre")
	public List<CategorieChambreProduit> getCategorieChambreProduits() {
		return categorieChambreProduits;
	}

	public void setCategorieChambreProduits(List<CategorieChambreProduit> categorieChambreProduits) {
		this.categorieChambreProduits = categorieChambreProduits;
	}

	@Override
	public String toString() {
		return "CategorieChambre [id=" + id + ", libelle=" + libelle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categorieChambreProduits == null) ? 0
						: categorieChambreProduits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		CategorieChambre other = (CategorieChambre) obj;
		if (categorieChambreProduits == null) {
			if (other.categorieChambreProduits != null)
				return false;
		} else if (!categorieChambreProduits
				.equals(other.categorieChambreProduits))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}   
	
	

   
}
