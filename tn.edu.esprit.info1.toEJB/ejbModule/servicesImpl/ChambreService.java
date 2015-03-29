package servicesImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.CategorieChambre;

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

   
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieChambre> getAllCategorieChambre() {
		
		return entityManager.createQuery("select c from CategorieChambre c").getResultList();
		 
	}

	@Override
	public Boolean addCategorieChambre(CategorieChambre categorieChambre) {
		// TODO Auto-generated method stub
		Boolean b = false;
		try {
			entityManager.persist(categorieChambre);
			b = true;
		} catch (Exception e) {
			System.out.println("insertion errors ...");
		}
		return b;
	}
}
