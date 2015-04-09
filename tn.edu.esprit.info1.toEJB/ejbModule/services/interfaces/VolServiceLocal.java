package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import utils.TypePlace;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Place;
import domain.Vol;

@Local
public interface VolServiceLocal {
	public Boolean addVol(Vol vol);
	public Boolean updateVol(Vol vol);
	public Boolean deleteVol(Vol vol);
	
	public Boolean addCompany(Compagnie compagnie);
	public Boolean updateCompany(Compagnie compagnie);
	public Boolean deleteCompany(Compagnie compagnie);
	
	public Boolean addPlane(Avion avion);
	public Boolean updatePlane(Avion avion);
	public Boolean deletePlane(Avion avion);
	
	public Boolean addPlace(Place place);
	public Boolean updatePlace(Place place);
	public Boolean deletePlace(Place place);
	
	public List<Vol> getVols();
	public List<Aeroport> getAeroports();
	public List<Compagnie> getCompagnies();
	public List<Avion> getAvions();
	public List<Place> getPlaces();
	
	public List<Avion> findAvionsByCompany(Integer id);
	public List<Vol> findVolsByCompany(Integer id);
	public List<Vol> findVolsByAvion(Integer id);
	public Aeroport findAeroportById(Integer id);
	public Avion findAvionById(Integer id);
	public Vol findVolById(Integer id);
	public Compagnie findCompanyById(Integer id);
	public Place findPlaceById(Integer id);
	
	 
}
