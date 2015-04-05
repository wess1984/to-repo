package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import services.interfaces.HotelServiceLocal;
import domain.Hotel;

@ManagedBean
@RequestScoped
public class HotelBean implements Serializable {

	private List<Hotel> hotels;
	private Hotel selectedHotel = new Hotel();
	
	@EJB
	HotelServiceLocal hotelServiceLocal;

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
		hotelServiceLocal.addHotel(selectedHotel);
	}
	public void doUpdateHotel(){
		hotelServiceLocal.updateHotel(selectedHotel);
	}
	
	public void doDeleteHotel(){
		hotelServiceLocal.deleteHote(selectedHotel);
	}
	
	public void resetInput(){
		this.selectedHotel = new Hotel();
		
		
	}
}
