package tn.edu.esprit.info1.toWeb;


import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.poll.Poll;

import services.interfaces.ChambreServiceLocal;
import domain.CategorieChambre;


@ManagedBean
@ViewScoped
public class ChambreBean {

		
	List<CategorieChambre> categoriesChambre = new LinkedList<>();
	CategorieChambre categorieChambre ;
	
	@PostConstruct
	public void init(){
	 categorieChambre	= new CategorieChambre();
	}
	
	@EJB
	ChambreServiceLocal chambreServiceLocal;

	public List<CategorieChambre> getcategoriesChambre() {
		categoriesChambre = chambreServiceLocal.getAllCategorieChambre();
		return categoriesChambre;
	}

	public void setcategoriesChambre(List<CategorieChambre> categoriesChambre) {
		this.categoriesChambre = categoriesChambre;
	}
		
    
	public CategorieChambre getCategorieChambre() {
		System.out.println(this.categorieChambre.getLibelle());
		return this.categorieChambre;
	}

	public void setCategorieChambre(CategorieChambre categorieChambre) {
		this.categorieChambre = categorieChambre;
	}

	public ChambreServiceLocal getChambreServiceLocal() {
		return chambreServiceLocal;
	}

	public void setChambreServiceLocal(ChambreServiceLocal chambreServiceLocal) {
		this.chambreServiceLocal = chambreServiceLocal;
	}
	
	public void doAddCategorieChambre(){
		chambreServiceLocal.addCategorieChambre(categorieChambre);
	}
    
}
