package servicesImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.CategorieChambre;
import domain.Hotel;
import services.interfaces.HotelServiceLocal;


/**
 * Session Bean implementation class HotelService
 */
@Stateless

@LocalBean
public class HotelService implements HotelServiceLocal {

    
	@PersistenceContext
	EntityManager entityManager;
	
    public HotelService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Hotel> getAllHotel() {
		return entityManager.createQuery("select h from Hotel h").getResultList();
	}

	@Override
	public Boolean addHotel(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.persist(hotel);
			b = true;
		} catch (Exception e) {
			System.out.println("insertion errors ...");
		}
		return b;
	}

	@Override
	public Boolean updateHotel(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.merge(hotel);
			b = true;
		} catch (Exception e) {
			System.out.println("updating  errors ...");
		}
		return b;
	}

	@Override
	public Boolean deleteHote(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Hotel.class, hotel.getId()));
			b = true;
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("delete errors ...");
		}
		return b;
	}

}
