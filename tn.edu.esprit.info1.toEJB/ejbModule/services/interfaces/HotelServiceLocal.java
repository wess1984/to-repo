package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.CategorieChambre;
import domain.Hotel;

@Local
public interface HotelServiceLocal {

	List<Hotel> getAllHotel();
	Boolean addHotel(Hotel hotel);
	Boolean updateHotel(Hotel hotel);
	Boolean deleteHote(Hotel hotel);
}
