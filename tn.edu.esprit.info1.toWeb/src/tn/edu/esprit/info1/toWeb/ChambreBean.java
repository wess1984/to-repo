package tn.edu.esprit.info1.toWeb;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import services.interfaces.ChambreServiceLocal;
import domain.Chambre;

@ManagedBean
@SessionScoped
public class ChambreBean {

	List<Chambre> chambres = new LinkedList<>();
	
	@EJB
	ChambreServiceLocal chambreServiceLocal;

	public List<Chambre> getChambres() {
		chambres = chambreServiceLocal.getAll();
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	
	
}
