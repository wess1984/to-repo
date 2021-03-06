package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.context.RequestContext;

import services.interfaces.VolServiceLocal;
import utils.Emplacement;
import utils.TypePlace;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Place;
import domain.Vol;

@ManagedBean
@ViewScoped
public class VolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Vol selectedVol;
	private Compagnie selectedCompany;
	private Avion selectedAvion;
	private Place selectedPlace;
	private List<Vol> vols = new ArrayList<>();
	private List<Aeroport> aeroports = new ArrayList<>();
	private List<Compagnie> compagnies = new ArrayList<>();
	private List<Avion> avions = new ArrayList<>();
	private List<Place> places = new ArrayList<>();
	private String selectedAeroportDepartId = null;
	private String selectedAeroportArriveeId = null;
	private String selectedCompanyId = null;
	private String selectedAvionId = null;
	private Boolean visible = true;
	private String prixPlaceEcoNormal = null;
	private String prixPlaceEcoFenetre = null;
	private String prixPlaceBusiness = null;
	

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
		// get vols by selected company
		if(getSelectedCompany().getId()!=null){
			vols = serviceLocal.findVolsByCompany(getSelectedCompany().getId());
		}
		//get vols by selected plane
		if(getSelectedAvion().getId()!=null){
			vols = serviceLocal.findVolsByAvion(getSelectedAvion().getId());
		}
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
		
		if(getSelectedCompany().getId()!=null)
			avions = serviceLocal.findAvionsByCompany(getSelectedCompany().getId());
		
		if(getSelectedCompanyId()!=null && getSelectedCompanyId()!="")
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

	public Compagnie getSelectedCompany() {
		if(selectedCompany==null) selectedCompany = new Compagnie();
		return selectedCompany;
	}

	public void setSelectedCompany(Compagnie selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public List<Place> getPlaces() {
		
		if(getSelectedVol().getId()!=null){
			places = getSelectedVol().getPlaces();
		}else{
			places= null;
		}
		return places;
	}
	

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Avion getSelectedAvion() {
		if(selectedAvion == null) selectedAvion = new Avion();
		
		if(selectedAvion.getCompagnie()!=null)
			setSelectedCompanyId(selectedAvion.getCompagnie().getId().toString());
		
		return selectedAvion;
	}

	public void setSelectedAvion(Avion selectedAvion) {
		this.selectedAvion = selectedAvion;
	}

	public Place getSelectedPlace() {
		if(selectedPlace==null) selectedPlace = new Place();
		
		if(selectedPlace.getType()!=null){
			if(selectedPlace.getType().equals(TypePlace.Business)) setVisible(false);
			else setVisible(true);
		}
		return selectedPlace;
	}

	public void setSelectedPlace(Place selectedPlace) {
		this.selectedPlace = selectedPlace;
	}
	
	public TypePlace[] getTypesPlace(){
		return TypePlace.values();
	}
	
	public Emplacement[] getEmplacements(){
		return Emplacement.values();
	}
	

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getPrixPlaceEcoFenetre() {
		return prixPlaceEcoFenetre;
	}

	public void setPrixPlaceEcoFenetre(String prixPlaceEcoFenetre) {
		this.prixPlaceEcoFenetre = prixPlaceEcoFenetre;
	}

	public String getPrixPlaceEcoNormal() {
		return prixPlaceEcoNormal;
	}

	public void setPrixPlaceEcoNormal(String prixPlaceEcoNormal) {
		this.prixPlaceEcoNormal = prixPlaceEcoNormal;
	}

	public String getPrixPlaceBusiness() {
		return prixPlaceBusiness;
	}

	public void setPrixPlaceBusiness(String prixPlaceBusiness) {
		this.prixPlaceBusiness = prixPlaceBusiness;
	}

	/** Methods **/
	public String doAddVol(){
		List<Place> places = new ArrayList<>();
		Aeroport depart = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId()));
		getSelectedVol().setDepart(depart);
		
		Aeroport arrivee = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportArriveeId()));
		getSelectedVol().setArrivee(arrivee);
		
		Avion selectedAvion = serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId()));
		getSelectedVol().setAvion(selectedAvion);
		
		Float prixPlaceNormal = 0.0f,prixPlaceFenetre=0.0f,prixPlaceBusi=0.0f;
		if(prixPlaceEcoNormal!=null) prixPlaceNormal = Float.parseFloat(prixPlaceEcoNormal);
		if(prixPlaceEcoFenetre!=null) prixPlaceFenetre = Float.parseFloat(prixPlaceEcoFenetre);
		if(prixPlaceBusiness!=null) prixPlaceBusi = Float.parseFloat(prixPlaceBusiness);
		
		/* R�partiton des places selon l'avion s�lectionn� pour ce vol */
		// places economiques normal
		for (int i = 0; i < selectedAvion.getNombrePlaceEconomique()/2; i++) {
			places.add(new Place("PEN", TypePlace.Economique, Emplacement.Normal, false, prixPlaceNormal, 0.0f));
		}
		// places economiques pr�t du fenetre		
		for (int i = selectedAvion.getNombrePlaceEconomique()/2; i <selectedAvion.getNombrePlaceEconomique() ; i++) {
			places.add(new Place("PEF", TypePlace.Economique, Emplacement.Fenetre, false, prixPlaceFenetre, 0.0f));
		}
		// places business
		for (int i = 0; i < selectedAvion.getNombrePlaceBusiness(); i++) {
			places.add(new Place("PB", TypePlace.Business, Emplacement.Fenetre, false, prixPlaceBusi, 0.0f));
		}
		
		getSelectedVol().setPlaces(places);
		
		serviceLocal.addVol(getSelectedVol());
		
		return "";
	}

	public String doUpdateVol(){
		Aeroport depart = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId()));
		getSelectedVol().setDepart(depart);
		
		Aeroport arrivee = serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportArriveeId()));
		getSelectedVol().setArrivee(arrivee);
		
		Avion selectedAvion = serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId()));
		getSelectedVol().setAvion(selectedAvion);
		
		serviceLocal.updateVol(getSelectedVol());
		
		return "";
	}
	
	public String doDeleteVol(){
		serviceLocal.deleteVol(getSelectedVol());
		return "";
	}
	
	public String doAddCompany(){
		serviceLocal.addCompany(getSelectedCompany());
		return "";
	}
	
	public String doUpdateCompany(){
		serviceLocal.updateCompany(getSelectedCompany());
		return "";
	}
	
	public String doDeleteCompany(){
		serviceLocal.deleteCompany(getSelectedCompany());
		return "";
	}
	
	public String doAddPlane(){
		Compagnie compagnie = null;
		
		if(getSelectedCompanyId().trim()!=null) compagnie = serviceLocal.findCompanyById(Integer.parseInt(getSelectedCompanyId()));
		
		if(compagnie!=null) getSelectedAvion().setCompagnie(compagnie);
		
		serviceLocal.addPlane(getSelectedAvion());
		
		return "";
	}
	
	public String doUpdatePlane(){
		Compagnie compagnie = null;
		
		if(getSelectedCompanyId().trim()!=null) compagnie = serviceLocal.findCompanyById(Integer.parseInt(getSelectedCompanyId()));

		if(compagnie!=null) getSelectedAvion().setCompagnie(compagnie);
		
		serviceLocal.updatePlane(getSelectedAvion());
		
		return "";
	}
	
	public String doDeletePlane(){
		serviceLocal.deletePlane(getSelectedAvion());
		
		return "";
	}
	
	public String doAddPlace(){
		
		serviceLocal.addPlace(getSelectedPlace());
		return "";
	}
	
	public String doUpdatePlace(){
		serviceLocal.updatePlace(getSelectedPlace());
		return "";
	}
	
	public String doDeletePlace(){
		serviceLocal.deletePlace(getSelectedPlace());
		return "";
	}
	
	/** Events **/
	 public void companyChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != getSelectedCompanyId()) {
	            setSelectedAvionId(null);
	            setSelectedAvion(null);
	            setSelectedCompanyId(event.getNewValue().toString());
	        }
	 }
	 
	 public void avionChangeListener(ValueChangeEvent event) {
		 Avion avion;   
		 if (event.getNewValue() != getSelectedAvionId()) {
	            setSelectedAvionId(event.getNewValue().toString());
	            avion = serviceLocal.findAvionById(Integer.parseInt(getSelectedAvionId()));
	            getSelectedVol().setAvion(avion);
	        }
	 }
	 
	 public void departAeroportChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != getSelectedAeroportDepartId()) {
	            setSelectedAeroportDepartId(event.getNewValue().toString());
	            getSelectedVol().setDepart(serviceLocal.findAeroportById(Integer.parseInt(getSelectedAeroportDepartId())));
	        }
	 }
	 
	 public void typePlaceChangeListener(ValueChangeEvent event){
		 if ((event.getNewValue() != getSelectedPlace().getType()) && event.getNewValue().equals(TypePlace.Business)){ 
			getSelectedPlace().setType(TypePlace.Business);
		 }else{
			 getSelectedPlace().setType(TypePlace.Economique);
		 }
	 }
	 

	 public void resetCompanyFormListener() {
		 //setSelectedCompany(new Compagnie());
	 }
	 public void resetAvionFormListener() {
		 //setSelectedAvion(new Avion());
	 }
	 public void resetVolFormListener() {
		 //setSelectedVol(new Vol());
	 }
	 
	 public void onCompanyRowSelect(SelectEvent event) {
		 Compagnie compagnie = (Compagnie) event.getObject();
		 setSelectedCompany(compagnie);
		 setSelectedCompanyId(compagnie.getId().toString());
		 setSelectedAvion(null);
		 setSelectedVol(null);
		 setPlaces(null);
	 }
	 public void onPlaneRowSelect(SelectEvent event) {
		 Avion avion = (Avion) event.getObject();
		 setSelectedAvion(avion);
		 setSelectedAvionId(avion.getId().toString());
		 setSelectedVol(null);
		 setPlaces(null);
	 }
	 public void onVolRowSelect(SelectEvent event) {
		 Vol vol = (Vol) event.getObject();
		 setSelectedVol(vol);
	 }
	 
}
