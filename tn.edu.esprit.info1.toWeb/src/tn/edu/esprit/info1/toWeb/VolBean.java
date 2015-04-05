package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.interfaces.VolServiceLocal;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Vol;

@ManagedBean
@ViewScoped
public class VolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Vol selectedVol = new Vol();
	private List<Vol> vols = new ArrayList<>();
	private List<Aeroport> aeroports = new ArrayList<>();
	private List<Compagnie> compagnies = new ArrayList<>();
	private List<Avion> avions = new ArrayList<>();

	@EJB
	VolServiceLocal serviceLocal;
	
	public VolBean(){}
	
	public Vol getSelectedVol() {
		return selectedVol;
	}

	public void setSelectedVol(Vol selectedVol) {
		this.selectedVol = selectedVol;
	}

	public List<Vol> getVols() {
		return serviceLocal.getVols();
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	public List<Compagnie> getCompagnies() {
		return compagnies;
	}

	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}

	public List<Avion> getAvions() {
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}
	
	
	/**Methods**/
	public String doAddVol(){
		return "";
	}

	public String doUpdateVol(){
		return "";
	}
	
	public String doDeleteVol(){
		return "";
	}

}
