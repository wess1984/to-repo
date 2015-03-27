package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Chambre;

@Local
public interface ChambreServiceLocal {
	Boolean addChambre(Chambre chambre);
	List<Chambre> getAll();
}
