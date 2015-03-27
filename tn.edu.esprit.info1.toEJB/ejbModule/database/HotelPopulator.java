package database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Chambre;
import domain.Hotel;
import domain.Produit;

@Singleton
@Startup
@LocalBean
public class HotelPopulator {

	private List<Chambre> chambres = new ArrayList<>();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@PostConstruct
	public void initDb() {
		initChambres();
		
		Produit produit = new Hotel("H01546", "BE LIVE LANZAROTE RESORT 4*", "", "4****",this.chambres);
		entityManager.persist(produit);
		
	}

	private void initChambres() {
		Chambre chambre1 = new Chambre("CHAMBRE VUE JARDIN", 2);
		Chambre chambre2 = new Chambre("CHAMBRE VUE MER", 2);
		Chambre chambre3 = new Chambre("CHAMBRE VUE MER AVEC PISCINE PRIVEE", 2);
		Chambre chambre4 = new Chambre("CHAMBRE VUE MER LATERALE", 2);
		Chambre chambre5 = new Chambre("GARDEN VIEW PISCINE", 2);
		Chambre chambre6 = new Chambre("MAISONNETTE", 2);
		Chambre chambre7 = new Chambre("STANDARD", 2);
		Chambre chambre8 = new Chambre("STUDIO VUE MER PARTIELLE", 2);
		Chambre chambre9 = new Chambre("SUITE", 2);
		Chambre chambre10= new Chambre("SUITE AVEC JACUZZI SUR TERRASSE", 2);
		Chambre chambre11= new Chambre("SUITE AVEC PISCINE PRIVEE", 2);
		Chambre chambre12= new Chambre("SUITE FAMILIALE", 2);
		Chambre chambre13= new Chambre("SUITE FAMILIALE 2 CHAMBRES", 2);
		Chambre chambre14= new Chambre("SUITE JUNIOR", 2);
		Chambre chambre15= new Chambre("SUITE JUNIOR AVEC PISCINE PRIVEE", 2);
		Chambre chambre16= new Chambre("SUITE ROYAL", 2);
		Chambre chambre17= new Chambre("CHAMBRE VUE MONTAGNE", 2);
		Chambre chambre18= new Chambre("CHAMBRE VUE MER PARTIELLE", 2);
	
		
		entityManager.persist(chambre1);
		entityManager.persist(chambre2);
		entityManager.persist(chambre3);
		entityManager.persist(chambre4);
		entityManager.persist(chambre5);
		entityManager.persist(chambre6);
		entityManager.persist(chambre7);
		entityManager.persist(chambre8);
		entityManager.persist(chambre9);
		entityManager.persist(chambre10);
		entityManager.persist(chambre11);
		entityManager.persist(chambre12);
		entityManager.persist(chambre13);
		entityManager.persist(chambre14);
		entityManager.persist(chambre15);
		entityManager.persist(chambre16);
		entityManager.persist(chambre17);
		entityManager.persist(chambre18);
		
		chambres.add(chambre1);
		chambres.add(chambre2);
		chambres.add(chambre3);
		chambres.add(chambre4);
		chambres.add(chambre5);
		chambres.add(chambre6);
		chambres.add(chambre7);
		chambres.add(chambre8);
		chambres.add(chambre9);
		chambres.add(chambre10);
		chambres.add(chambre11);
		chambres.add(chambre12);
		chambres.add(chambre13);
		chambres.add(chambre14);
		chambres.add(chambre15);
		chambres.add(chambre16);
		chambres.add(chambre17);
		chambres.add(chambre18);
		
		
	}

}
