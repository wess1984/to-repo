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


import utils.Emplacement;
import utils.TypePlace;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Place;
import domain.Vol;

@Singleton
@Startup
@LocalBean
public class VolPopulator {

	@PersistenceContext
	private EntityManager entityManager;
	
	private List<Avion> avions = new ArrayList<>();
	private List<Place> places = new ArrayList<>();
	private Compagnie compagnie1,compagnie2;
	
	
	@PostConstruct
	public void initDb() {
		initAeroports();
		initCompagnies();
		initAvions();
		initPlaces();
		
		Aeroport depart  = entityManager.find(Aeroport.class, 1);
		Aeroport arrivee = entityManager.find(Aeroport.class, 5);
		
		Vol vol = new Vol("TN001", depart, arrivee, new Date(), new Date(), avions.get(1),places);
		
		vol.setDesignation("Tunis -> Djerba");
		vol.setPlaces(places);
		entityManager.persist(vol);
	}

	private void initAeroports() {
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
	
	private void initCompagnies() {
		compagnie1 = new Compagnie("TN", "Tunisair", null); 
		compagnie2 = new Compagnie("SYP", "Syphax airlines", null);
		
		entityManager.persist(compagnie1);
		entityManager.persist(compagnie2);
	}
	
	private void initAvions() {
		Avion avion1 = new Avion("Airbus", "A320", true, true, 10, 2, compagnie1, null);
		Avion avion2 = new Avion("Boeing", "B737", true, true, 12, 4, compagnie1, null);
		Avion avion3 = new Avion("Airbus", "A330", true, true, 15, 8, compagnie1, null);
		Avion avion4 = new Avion("Airbus", "A340", true, true, 14, 10, compagnie2, null);
		Avion avion5 = new Avion("Boeing", "B747", true, true, 15, 15, compagnie2, null);
		Avion avion6 = new Avion("Airbus", "A330", true, true, 7, 7, compagnie2, null);
		
		avions.add(avion1);
		avions.add(avion2);
		avions.add(avion3);
		avions.add(avion4);
		avions.add(avion5);
		avions.add(avion6);
		
		entityManager.persist(avion1);
		entityManager.persist(avion2);
		entityManager.persist(avion3);
		entityManager.persist(avion4);
		entityManager.persist(avion5);
		entityManager.persist(avion6);
		
		
	}
	
	private void initPlaces() {
		Place place1 = new Place("A01", TypePlace.Business,Emplacement.Fenetre,false, 300.0F, 0.0F);
		Place place2 = new Place("A02", TypePlace.Economique,Emplacement.Normal,false, 280.0F, 0.0F);
		Place place3 = new Place("B01", TypePlace.Economique,Emplacement.Fenetre,false, 270.0F, 0.0F);
		Place place4 = new Place("B02", TypePlace.Economique,Emplacement.Normal,false, 240.0F, 0.0F);
		Place place5 = new Place("C01", TypePlace.Economique,Emplacement.Normal,false, 210.0F, 0.0F);
		
		entityManager.persist(place1);
		entityManager.persist(place2);
		entityManager.persist(place3);
		entityManager.persist(place4);
		entityManager.persist(place5);
		
		places.add(place1);
		places.add(place2);
		places.add(place3);
		places.add(place4);
		places.add(place5);
	}

}
