package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import services.interfaces.VolServiceLocal;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Vol;

@ManagedBean
@ViewScoped
public class VolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Vol selectedVol;
	private List<Vol> vols = new ArrayList<>();
	private List<Aeroport> aeroports = new ArrayList<>();
	private List<Compagnie> compagnies = new ArrayList<>();
	private List<Avion> avions = new ArrayList<>();
	private String selectedAeroportDepartId = null;
	private String selectedAeroportArriveeId = null;
	private String selectedCompanyId = null;
	private String selectedAvionId = null;

	@EJB
	VolServiceLocal serviceLocal;
	
	public VolBean(){}
	
	public Vol getSelectedVol() {
		if(selectedVol==null) selectedVol = new Vol();

		if(selectedVol.getDepart()!=null)  setSelectedAeroportDepartId(selectedVol.getDepart().getId().toString());
		
		if(selectedVol.getArrivee()!=null) setSelectedAeroportArriveeId(selectedVol.getArrivee().getId().toString());
		if(selectedVol.getAvion()!=null){
			setSelectedCompanyId(selectedVol.getAvion().getCompagnie().getId().toString());
			setSelectedAvionId(selectedVol.getAvion().getId().toString());
		}
		
		return selectedVol;
	}

	public void setSelectedVol(Vol selectedVol) {
		this.selectedVol = selectedVol;
	}

	public List<Vol> getVols() {
		vols = serviceLocal.getVols();
		
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public List<Aeroport> getAeroports() {
		aeroports = serviceLocal.getAeroports();
		return aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	public List<Compagnie> getCompagnies() {
		compagnies = serviceLocal.getCompagnies();
		return compagnies;
	}

	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}

	public List<Avion> getAvions() {
		if(getSelectedCompanyId()!=null)
			avions = serviceLocal.findAvionsByCompany(Integer.parseInt(getSelectedCompanyId()));
		
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}
	
	
	public String getSelectedAeroportDepartId() {
		return selectedAeroportDepartId;
	}

	public String getSelectedAeroportArriveeId() {
		return selectedAeroportArriveeId;
	}

	public void setSelectedAeroportArriveeId(String selectedAeroportArriveeId) {
		this.selectedAeroportArriveeId = selectedAeroportArriveeId;
	}

	public void setSelectedAeroportDepartId(String selectedAeroportDepartId) {
		this.selectedAeroportDepartId = selectedAeroportDepartId;
	}

	public String getSelectedCompanyId() {
		return selectedCompanyId;
	}

	public void setSelectedCompanyId(String selectedCompanyId) {
		this.selectedCompanyId = selectedCompanyId;
	}
	
	public String getSelectedAvionId() {
		return selectedAvionId;
	}

	public void setSelectedAvionId(String selectedAvionId) {
		this.selectedAvionId = selectedAvionId;
	}

	/** Methods **/
	public String doAddVol(){
		
		Aeroport depart = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId()));
		selectedVol.setDepart(depart);
		
		Aeroport arrivee = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportArriveeId()));
		selectedVol.setArrivee(arrivee);
		
		Avion selectedAvion = serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId()));
		selectedVol.setAvion(selectedAvion);
		
		serviceLocal.addVol(selectedVol);
		
		return "";
	}

	public String doUpdateVol(){
		Aeroport depart = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId()));
		selectedVol.setDepart(depart);
		
		Aeroport arrivee = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportArriveeId()));
		selectedVol.setArrivee(arrivee);
		
		Avion selectedAvion = serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId()));
		selectedVol.setAvion(selectedAvion);
		
		serviceLocal.updateVol(selectedVol);
		
		return "";
	}
	
	public String doDeleteVol(){
		serviceLocal.deleteVol(selectedVol);
		return "";
	}
	
	/** Events **/
	 public void companyChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != getSelectedCompanyId()) {
	            setSelectedAvionId(null);
	            setSelectedCompanyId(event.getNewValue().toString());
	        }
	 }
	 
	 public void avionChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != getSelectedAvionId()) {
	            setSelectedAvionId(event.getNewValue().toString());
	            selectedVol.setAvion(serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId())));
	        }
	 }
	 
	 public void departAeroportChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != getSelectedAeroportDepartId()) {
	            setSelectedAeroportDepartId(event.getNewValue().toString());
	            selectedVol.setDepart(serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId())));
	        }
	 }
	 
	 
	 public void resetFormListener() {
		// reset the view map 
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	 }

}
