package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.CategorieChambre;
import domain.CategorieChambreProduit;
import domain.Hotel;

@Local
public interface HotelServiceLocal {

	List<Hotel> getAllHotel();
	Boolean addHotel(Hotel hotel);
	Boolean updateHotel(Hotel hotel);
	Boolean deleteHote(Hotel hotel);
	List<CategorieChambreProduit> getCategoriesChambreByHotel(Integer id);
	Boolean addCategorieChambre(Hotel hotel,CategorieChambreProduit categorieChambreProduit);
}
