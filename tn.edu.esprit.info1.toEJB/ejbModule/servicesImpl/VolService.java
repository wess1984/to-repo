package servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Place;
import domain.Vol;
import services.interfaces.VolServiceLocal;
import services.interfaces.VolServiceRemote;
import utils.TypePlace;


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
		}catch(Exception e){
			System.err.println(e);
			System.err.println("Error on addVol action ...");
		}
		
		return state;
	}

	@Override
	public Boolean updateVol(Vol vol) {
		Boolean state= false;
		try{
			entityManager.merge(vol);
			state = true;
		}catch(Exception e){
			System.err.println(e);
			System.err.println("Error on updateVol action ...");
		}
		return state;
	}

	@Override
	public Boolean deleteVol(Vol vol) {
		Boolean state= false;
		try{
			entityManager.remove(this.findVolById(vol.getId()));
			state = true;
		}catch(Exception e){
			System.err.println(e);
			System.err.println("Error on deleteVol action ...");
		}
		
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Compagnie> getCompagnies() {
		return entityManager.createQuery("SELECT c from Compagnie c").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avion> findAvionsByCompany(Integer code) {
		
		TypedQuery<Avion> query = entityManager.createQuery("SELECT av from Avion av WHERE av.compagnie.id=:inputCode",Avion.class);
		query.setParameter("inputCode", code);
		
		
		return query.getResultList();
	}

	@Override
	public Avion findAvionById(Integer id) {
		return entityManager.find(Avion.class, id);
	}

	

}
