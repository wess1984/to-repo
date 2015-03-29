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
	
	

   
}
