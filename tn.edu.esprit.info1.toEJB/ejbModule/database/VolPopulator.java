package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;







import domain.Aeroport;
import domain.CategorieChambre;
import domain.CategorieChambreProduit;
import domain.CategorieChambreProduitId;
import domain.Hotel;
import domain.Produit;
import domain.Vol;

@Singleton
@Startup
@LocalBean
public class VolPopulator {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@PostConstruct
	public void initDb() {
		initAeroport();
		
		Aeroport depart  = entityManager.find(Aeroport.class, 1);
		Aeroport arrivee = entityManager.find(Aeroport.class, 5);
		
		Vol vol = new Vol("TN001", new Date(), new Date(), depart, arrivee, 120);
		vol.setDesignation("Tunis -> Dejerba");
		entityManager.persist(vol);
	}

	private void initAeroport() {
		Aeroport areAeroport1 = new Aeroport("Aeroport Tunis Carthage", "Ariana");
		Aeroport areAeroport2 = new Aeroport("Aeroport Monastir", "Monastir");
		Aeroport areAeroport3 = new Aeroport("Aeroport Enfidha", "Enfidha");
		Aeroport areAeroport4 = new Aeroport("Aeroport Sfax", "Sfax");
		Aeroport areAeroport5 = new Aeroport("Aeroport Djerba-Zarzis", "Djerba");
		Aeroport areAeroport6 = new Aeroport("Aeroport Tozeur-Nefta", "Tozeur");
		
		entityManager.persist(areAeroport1);
		entityManager.persist(areAeroport2);
		entityManager.persist(areAeroport3);
		entityManager.persist(areAeroport4);
		entityManager.persist(areAeroport5);
		entityManager.persist(areAeroport6);
		
		
	}

}
