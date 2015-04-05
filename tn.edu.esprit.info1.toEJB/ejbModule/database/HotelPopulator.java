package database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import domain.CategorieChambre;
import domain.CategorieChambreProduit;
import domain.CategorieChambreProduitId;
import domain.Hotel;
import domain.Produit;

@Singleton
@Startup
@LocalBean
public class HotelPopulator {

	private List<CategorieChambre> categorieChambres = new ArrayList<>();
	private List<CategorieChambreProduit> categorieChambresProduit = new ArrayList<>();
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@PostConstruct
	public void initDb() {
		initCategorieChambres();
		
		Hotel hotel = new Hotel("H01546", "BE LIVE LANZAROTE RESORT 4*", "", "4****",null);
		
		entityManager.persist(hotel);
		
		for (CategorieChambre category : categorieChambres) {
			CategorieChambreProduitId ccpid=new CategorieChambreProduitId();
		
			ccpid.setIdCategorieChambre(category.getId());
			ccpid.setIdProduit(hotel.getId());
			CategorieChambreProduit ccp= new CategorieChambreProduit();
			ccp.setStock(2);
			ccp.setTypeChambre("Double");
			ccp.setCategorieChambreProduitId(ccpid);
			//System.out.println(hotel.getId());System.out.println(category.getId());
			entityManager.persist(ccp);
		}
		
	}

	private void initCategorieChambres() {
		CategorieChambre categorieChambre1 = new CategorieChambre("CategorieChambre VUE JARDIN");
		CategorieChambre categorieChambre2 = new CategorieChambre("CategorieChambre VUE MER");
		CategorieChambre categorieChambre3 = new CategorieChambre("CategorieChambre VUE MER AVEC PISCINE PRIVEE");
		CategorieChambre categorieChambre4 = new CategorieChambre("CategorieChambre VUE MER LATERALE");
		CategorieChambre categorieChambre5 = new CategorieChambre("GARDEN VIEW PISCINE");
		CategorieChambre categorieChambre6 = new CategorieChambre("MAISONNETTE");
		CategorieChambre categorieChambre7 = new CategorieChambre("STANDARD");
		CategorieChambre categorieChambre8 = new CategorieChambre("STUDIO VUE MER PARTIELLE");
		CategorieChambre categorieChambre9 = new CategorieChambre("SUITE");
		CategorieChambre categorieChambre10= new CategorieChambre("SUITE AVEC JACUZZI SUR TERRASSE");
		CategorieChambre categorieChambre11= new CategorieChambre("SUITE AVEC PISCINE PRIVEE");
		CategorieChambre categorieChambre12= new CategorieChambre("SUITE FAMILIALE");
		CategorieChambre categorieChambre13= new CategorieChambre("SUITE FAMILIALE 2 CategorieChambreS");
		CategorieChambre categorieChambre14= new CategorieChambre("SUITE JUNIOR");
		CategorieChambre categorieChambre15= new CategorieChambre("SUITE JUNIOR AVEC PISCINE PRIVEE");
		CategorieChambre categorieChambre16= new CategorieChambre("SUITE ROYAL");
		CategorieChambre categorieChambre17= new CategorieChambre("CategorieChambre VUE MONTAGNE");
		CategorieChambre categorieChambre18= new CategorieChambre("CategorieChambre VUE MER PARTIELLE");
	
		
		entityManager.persist(categorieChambre1);
		entityManager.persist(categorieChambre2);
		entityManager.persist(categorieChambre3);
		entityManager.persist(categorieChambre4);
		entityManager.persist(categorieChambre5);
		entityManager.persist(categorieChambre6);
		entityManager.persist(categorieChambre7);
		entityManager.persist(categorieChambre8);
		entityManager.persist(categorieChambre9);
		entityManager.persist(categorieChambre10);
		entityManager.persist(categorieChambre11);
		entityManager.persist(categorieChambre12);
		entityManager.persist(categorieChambre13);
		entityManager.persist(categorieChambre14);
		entityManager.persist(categorieChambre15);
		entityManager.persist(categorieChambre16);
		entityManager.persist(categorieChambre17);
		entityManager.persist(categorieChambre18);
		
		categorieChambres.add(categorieChambre1);
		categorieChambres.add(categorieChambre2);
		categorieChambres.add(categorieChambre3);
		categorieChambres.add(categorieChambre4);
		categorieChambres.add(categorieChambre5);
		categorieChambres.add(categorieChambre6);
		categorieChambres.add(categorieChambre7);
		categorieChambres.add(categorieChambre8);
		categorieChambres.add(categorieChambre9);
		categorieChambres.add(categorieChambre10);
		categorieChambres.add(categorieChambre11);
		categorieChambres.add(categorieChambre12);
		categorieChambres.add(categorieChambre13);
		categorieChambres.add(categorieChambre14);
		categorieChambres.add(categorieChambre15);
		categorieChambres.add(categorieChambre16);
		categorieChambres.add(categorieChambre17);
		categorieChambres.add(categorieChambre18);
		
		
	}

}
