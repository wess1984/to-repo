package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CategorieChambreProduitId implements Serializable {

	private Integer idProduit;
	private Integer idCategorieChambre;
	
	
	
	
	public CategorieChambreProduitId(Integer idProduit,Integer idCategorieChambre) {
		
		this.idProduit = idProduit;
		this.idCategorieChambre = idCategorieChambre;
	}
	
	public CategorieChambreProduitId() {
		
	}

	
	
	@Override
	public String toString() {
		return "CategorieChambreProduitId [idProduit=" + idProduit
				+ ", idCategorieChambre=" + idCategorieChambre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idCategorieChambre == null) ? 0 : idCategorieChambre
						.hashCode());
		result = prime * result
				+ ((idProduit == null) ? 0 : idProduit.hashCode());
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
		CategorieChambreProduitId other = (CategorieChambreProduitId) obj;
		if (idCategorieChambre == null) {
			if (other.idCategorieChambre != null)
				return false;
		} else if (!idCategorieChambre.equals(other.idCategorieChambre))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		return true;
	}

	public Integer getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	public Integer getIdCategorieChambre() {
		return idCategorieChambre;
	}
	public void setIdCategorieChambre(Integer idCategorieChambre) {
		this.idCategorieChambre = idCategorieChambre;
	}
	
	
}
