package tn.edu.esprit.info1.toWeb;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import services.interfaces.ChambreServiceLocal;
import domain.CategorieChambre;


@ManagedBean
@RequestScoped
public class ChambreBean {

	List<CategorieChambre> categorieChambres = new LinkedList<>();
	
	@EJB
	ChambreServiceLocal chambreServiceLocal;

	public List<CategorieChambre> getCategorieChambres() {
		categorieChambres = chambreServiceLocal.getAllCategorieChambre();
		return categorieChambres;
	}

	public void setCategorieChambres(List<CategorieChambre> categorieChambres) {
		this.categorieChambres = categorieChambres;
	}
	
	
	
}
