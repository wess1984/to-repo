package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.CategorieChambre;


@Local
public interface ChambreServiceLocal {
	Boolean addCategorieChambre(CategorieChambre categorieChambre);
	Boolean updateCategorieChambre(CategorieChambre categorieChambre);
	List<CategorieChambre> getAllCategorieChambre();
	Boolean deleteCategorieChambre(CategorieChambre categorieChambre);
}
