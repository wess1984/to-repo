package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compagnie
 *
 */
@Entity

public class Compagnie implements Serializable {

	
	private Integer id;
	private String code;
	private String libelle;
	private List<Avion> avions;
	private static final long serialVersionUID = 1L;

	public Compagnie() {
		super();
	}   
	
	
	public Compagnie(String code, String libelle, List<Avion> avions) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.avions = avions;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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

	@OneToMany(mappedBy="compagnie")
	public List<Avion> getAvions() {
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}

	
   
}
