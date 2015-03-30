package tn.edu.esprit.info1.toWeb;


import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import services.interfaces.ChambreServiceLocal;
import domain.CategorieChambre;


@ManagedBean
@RequestScoped
public class ChambreBean {

		
	List<CategorieChambre> categoriesChambre = new LinkedList<>();
	CategorieChambre selectedChambre;
	
	@EJB
	ChambreServiceLocal chambreServiceLocal;

	public List<CategorieChambre> getcategoriesChambre() {
		categoriesChambre = chambreServiceLocal.getAllCategorieChambre();
		return categoriesChambre;
	}

	public void setcategoriesChambre(List<CategorieChambre> categoriesChambre) {
		this.categoriesChambre = categoriesChambre;
	}
		
    
	public CategorieChambre getSelectedChambre() {
		return selectedChambre;
	}

	public void setSelectedChambre(CategorieChambre categorieChambre) {
		this.selectedChambre = categorieChambre;
	}

	public ChambreServiceLocal getChambreServiceLocal() {
		return chambreServiceLocal;
	}

	public void setChambreServiceLocal(ChambreServiceLocal chambreServiceLocal) {
		this.chambreServiceLocal = chambreServiceLocal;
	}
	
    
}
