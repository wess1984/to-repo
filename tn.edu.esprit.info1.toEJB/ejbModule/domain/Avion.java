package domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Avion
 *
 */
@Entity

public class Avion implements Serializable {

	private Integer id;
	private String constructeur;
	private String modele;
	private Boolean classeEconomique;
	private Boolean classeBusiness;
	private Integer nombrePlaceEconomique;
	private Integer nombrePlaceBusiness;
	private Compagnie compagnie;
	private List<Vol> vols;
	private static final long serialVersionUID = 1L;

	public Avion() {
		super();
	}   
	
	public Avion(String constructeur, String modele, Boolean classeEconomique,
			Boolean classeBusiness, Integer nombrePlaceEconomique,
			Integer nombrePlaceBusiness, Compagnie compagnie, List<Vol> vols) {
		super();
		this.constructeur = constructeur;
		this.modele = modele;
		this.classeEconomique = classeEconomique;
		this.classeBusiness = classeBusiness;
		this.nombrePlaceEconomique = nombrePlaceEconomique;
		this.nombrePlaceBusiness = nombrePlaceBusiness;
		this.compagnie = compagnie;
		this.vols = vols;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getConstructeur() {
		return this.constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}   
	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}   
	public Boolean getClasseEconomique() {
		return this.classeEconomique;
	}

	public void setClasseEconomique(Boolean classeEconomique) {
		this.classeEconomique = classeEconomique;
	}   
	public Boolean getClasseBusiness() {
		return this.classeBusiness;
	}

	public void setClasseBusiness(Boolean classeBusiness) {
		this.classeBusiness = classeBusiness;
	}   
	public Integer getNombrePlaceEconomique() {
		return this.nombrePlaceEconomique;
	}

	public void setNombrePlaceEconomique(Integer nombrePlaceEconomique) {
		this.nombrePlaceEconomique = nombrePlaceEconomique;
	}   
	public Integer getNombrePlaceBusiness() {
		return this.nombrePlaceBusiness;
	}

	public void setNombrePlaceBusiness(Integer nombrePlaceBusiness) {
		this.nombrePlaceBusiness = nombrePlaceBusiness;
	}

	@ManyToOne
	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@OneToMany(mappedBy="avion")
	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	
}
