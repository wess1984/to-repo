package tn.edu.esprit.info1.toWeb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import domain.Hotel;
import services.interfaces.HotelServiceLocal;

@ManagedBean 
@RequestScoped
public class HotelBean {

	@EJB
	HotelServiceLocal hotelServiceLocal;
	
	private List<Hotel> hotels;
	
	private Hotel selectedHotel = new Hotel();
	
	public List<Hotel> getHotels() {
		return hotelServiceLocal.getAllHotel();
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel getSelectedHotel() {
		return selectedHotel;
	}

	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}
	
	public void doAddHotel(){
		System.out.println(selectedHotel);
		hotelServiceLocal.addHotel(selectedHotel);
	}
	
}
