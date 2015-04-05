package servicesImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
