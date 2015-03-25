package servicesImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import services.interfaces.ProduitServicesLocal;
import services.interfaces.ProduitServicesRemote;

/**
 * Session Bean implementation class ProduitServices
 */
@Stateless
@LocalBean
public class ProduitServices implements ProduitServicesRemote, ProduitServicesLocal {

    /**
     * Default constructor. 
     */
    public ProduitServices() {
        // TODO Auto-generated constructor stub
    }

}
