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
	
	
	public CategorieChambreProduit(
			CategorieChambreProduitId categorieChambreProduitId,
			String typeChambre, Integer stock, Hotel produit,
			CategorieChambre categorieChambre) {
		super();
		this.categorieChambreProduitId = categorieChambreProduitId;
		this.typeChambre = typeChambre;
		this.stock = stock;
		this.produit = produit;
		this.categorieChambre = categorieChambre;
	}
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
	@Override
	public String toString() {
		return "CategorieChambreProduit [categorieChambreProduitId="
				+ categorieChambreProduitId + ", typeChambre=" + typeChambre
				+ ", stock=" + stock + ", produit=" + produit
				+ ", categorieChambre=" + categorieChambre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categorieChambre == null) ? 0 : categorieChambre.hashCode());
		result = prime
				* result
				+ ((categorieChambreProduitId == null) ? 0
						: categorieChambreProduitId.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result
				+ ((typeChambre == null) ? 0 : typeChambre.hashCode());
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
		CategorieChambreProduit other = (CategorieChambreProduit) obj;
		if (categorieChambre == null) {
			if (other.categorieChambre != null)
				return false;
		} else if (!categorieChambre.equals(other.categorieChambre))
			return false;
		if (categorieChambreProduitId == null) {
			if (other.categorieChambreProduitId != null)
				return false;
		} else if (!categorieChambreProduitId
				.equals(other.categorieChambreProduitId))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (typeChambre == null) {
			if (other.typeChambre != null)
				return false;
		} else if (!typeChambre.equals(other.typeChambre))
			return false;
		return true;
	}
	
	
   
}
