package servicesImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Produit;
import services.interfaces.ProduitServicesLocal;
import services.interfaces.ProduitServicesRemote;

/**
 * Session Bean implementation class ProduitServices
 */
@Stateless
@LocalBean
public class ProduitServices implements ProduitServicesRemote, ProduitServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public ProduitServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addProduct(Produit produit) {
		Boolean b = false;
		try {
			entityManager.persist(produit);
			b = true;
		} catch (Exception e) {
			System.out.println("insertion errors ...");
		}
		return b;
	}

}
