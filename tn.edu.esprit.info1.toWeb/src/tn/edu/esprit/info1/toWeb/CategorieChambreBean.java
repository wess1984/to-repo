package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.validator.cfg.context.ReturnValueTarget;

import services.interfaces.ChambreServiceLocal;
import services.interfaces.HotelServiceLocal;
import domain.CategorieChambreProduit;
import domain.Hotel;

@ManagedBean
@ViewScoped
public class CategorieChambreBean implements Serializable {

	@ManagedProperty("#{hotelBean}")
	private HotelBean hotelBean;
	
	@EJB
	HotelServiceLocal hotelServiceLocal;
	
	
	private Hotel selectedHotel;
	private List<CategorieChambreProduit> categorieChambreProduits;
	
	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public Hotel getSelectedHotel() {
		selectedHotel= hotelBean.getSelectedHotel();
		return selectedHotel;
	}

	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	public List<CategorieChambreProduit> getCategorieChambreProduits() {
		
		categorieChambreProduits= hotelServiceLocal.getCategoriesChambreByHotel(selectedHotel.getId());
		
		return categorieChambreProduits;

	}

	public void setCategorieChambreProduits(List<CategorieChambreProduit> categorieChambreProduits) {
		this.categorieChambreProduits = categorieChambreProduits;
	}


}
