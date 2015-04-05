package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import services.interfaces.ChambreServiceLocal;
import domain.CategorieChambre;

@ManagedBean
@RequestScoped
public class ChambreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<CategorieChambre> categoriesChambre = new LinkedList<>();
	private CategorieChambre selectedCategorieChambre = new CategorieChambre();

	@EJB
	ChambreServiceLocal chambreServiceLocal;

	public List<CategorieChambre> getcategoriesChambre() {
		return chambreServiceLocal.getAllCategorieChambre();
	}

	public void setcategoriesChambre(List<CategorieChambre> categoriesChambre) {
		this.categoriesChambre = categoriesChambre;
	}

	public CategorieChambre getSelectedCategorieChambre() {
		return this.selectedCategorieChambre;
	}

	public void setSelectedCategorieChambre(CategorieChambre selectedCategorieChambre) {
		this.selectedCategorieChambre = selectedCategorieChambre;
	}
	
	public void doAddCategorieChambre() {
		chambreServiceLocal.addCategorieChambre(selectedCategorieChambre);
	}
	public void doUpdateCategorieChambre(){
		chambreServiceLocal.updateCategorieChambre(selectedCategorieChambre);
	}
	public void doDeleteCategorieChambre(){
		chambreServiceLocal.deleteCategorieChambre(selectedCategorieChambre);
	}
	
	public void resetInput(){
		this.selectedCategorieChambre.setId(-1);
		this.selectedCategorieChambre.setLibelle("");
	}

	
}
