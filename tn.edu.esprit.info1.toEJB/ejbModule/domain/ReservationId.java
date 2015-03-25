package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId implements Serializable{
	private Integer idUser;
	private Integer idProduit;
	
	public ReservationId() {
		// TODO Auto-generated constructor stub
	}

	public ReservationId(Integer idUser, Integer idProduit) {
		super();
		this.idUser = idUser;
		this.idProduit = idProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduit == null) ? 0 : idProduit.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		ReservationId other = (ReservationId) obj;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReservationId [idUser=" + idUser + ", idProduit=" + idProduit
				+ "]";
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	

}
