package tn.edu.esprit.info1.toWeb;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	
	public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
