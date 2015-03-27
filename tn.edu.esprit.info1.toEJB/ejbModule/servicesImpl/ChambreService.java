package servicesImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Chambre;
import domain.Produit;
import services.interfaces.ChambreServiceLocal;

/**
 * Session Bean implementation class ChambreService
 */
@Stateless
@LocalBean
public class ChambreService implements ChambreServiceLocal {

	@PersistenceContext
	EntityManager entityManager;


    public ChambreService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addChambre(Chambre chambre) {
		Boolean b = false;
		try {
			entityManager.persist(chambre);
			b = true;
		} catch (Exception e) {
			System.out.println("insertion errors ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chambre> getAll() {
		
		return entityManager.createQuery("select c from Chambre c").getResultList();
		 
	}
}
