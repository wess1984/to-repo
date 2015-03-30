package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aeroport
 *
 */
@Entity

public class Aeroport implements Serializable {

	private Integer id;
	private String nom;
	private String ville;
	private static final long serialVersionUID = 1L;

	public Aeroport() {

	}   
	
	
	
	public Aeroport(String nom, String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}



	/*@Override
	public String toString() {
		return  nom;
	}*/
	
	
   
}
