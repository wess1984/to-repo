package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Aeroport;
import domain.Vol;

@Local
public interface VolServiceLocal {
	public Boolean addVol(Vol vol);
	public List<Vol> getVols();
	
	public List<Aeroport> getAeroports();
	public Aeroport findAeroportById(Integer id);
	public Vol findVolById(Integer id);
	public Boolean updateVol(Vol vol);
	public Boolean deleteVol(Vol vol);
}