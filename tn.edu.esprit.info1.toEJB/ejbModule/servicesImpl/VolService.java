package servicesImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Aeroport;
import domain.Vol;
import services.interfaces.VolServiceLocal;
import services.interfaces.VolServiceRemote;

/**
 * Session Bean implementation class VolService
 */
@Stateless
@LocalBean
public class VolService implements VolServiceRemote, VolServiceLocal {

	
	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public VolService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addVol(Vol vol) {
		Boolean state = false;
		try {
			entityManager.persist(vol);
			state= true;
		}catch(Exception e){}
		
		return state;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> getVols() {
		List<Vol> vols =entityManager.createQuery("SELECT v from Vol v").getResultList();
		if(vols.isEmpty()) return null;
		return vols;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroport> getAeroports() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT a from Aeroport a").getResultList();
	}

	@Override
	public Aeroport findAeroportById(Integer id) {
		return entityManager.find(Aeroport.class, id);
	}

	@Override
	public Vol findVolById(Integer id) {
		return entityManager.find(Vol.class, id);
	}

}
