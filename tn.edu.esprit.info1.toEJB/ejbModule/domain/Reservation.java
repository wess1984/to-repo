package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Reservation
 * 
 */
@Entity
public class Reservation implements Serializable {

	private ReservationId reservationId;
	private Date dateDebut;
	private Date dateFin;
	private static final long serialVersionUID = 1L;

	private User user;
	private Produit produit;

	public Reservation() {
		super();
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@EmbeddedId
	public ReservationId getReservationId() {
		return reservationId;
	}

	public void setReservationId(ReservationId reservationId) {
		this.reservationId = reservationId;
	}

	@ManyToOne
	@JoinColumn(name="idUser",referencedColumnName="id",insertable=false,updatable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="idProduit",referencedColumnName="id",insertable=false,updatable=false)
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
