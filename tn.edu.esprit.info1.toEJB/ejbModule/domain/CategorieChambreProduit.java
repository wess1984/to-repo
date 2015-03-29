package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CategorieChambreProduit
 *
 */
@Entity

public class CategorieChambreProduit implements Serializable {

	private CategorieChambreProduitId categorieChambreProduitId;
	private String typeChambre;
	private Integer stock;
	private static final long serialVersionUID = 1L;

	private Hotel produit;
	private CategorieChambre categorieChambre;
	
	public CategorieChambreProduit() {
		super();
	}   
	public String getTypeChambre() {
		return this.typeChambre;
	}

	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}   
	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	@EmbeddedId
	public CategorieChambreProduitId getCategorieChambreProduitId() {
		return categorieChambreProduitId;
	}
	public void setCategorieChambreProduitId(CategorieChambreProduitId categorieChambreProduitId) {
		this.categorieChambreProduitId = categorieChambreProduitId;
	}
	
	@ManyToOne()
	@JoinColumn(name="idProduit",referencedColumnName="id",insertable=false,updatable=false)
	public Hotel getProduit() {
		return produit;
	}
	public void setProduit(Hotel produit) {
		this.produit = produit;
	}
	@ManyToOne
	@JoinColumn(name="idCategorieChambre",referencedColumnName="id",insertable=false,updatable=false)
	public CategorieChambre getCategorieChambre() {
		return categorieChambre;
	}
	public void setCategorieChambre(CategorieChambre categorieChambre) {
		this.categorieChambre = categorieChambre;
	}
   
}
