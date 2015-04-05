package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.log.Log;

import services.interfaces.VolServiceLocal;
import domain.Aeroport;
import domain.Avion;
import domain.Compagnie;
import domain.Vol;

@ManagedBean
@ViewScoped
public class VolBean implements Serializable {

		private static final long serialVersionUID = 1L;
		//Model
		public List<Vol> vols = new ArrayList<>();
		public List<Aeroport> aeroports = new ArrayList<>();
		public List<Compagnie> compagnies = new ArrayList<>();
		public List<Avion> avions = new ArrayList<>();
		private Vol vol= new Vol();
		private Vol selectedVol= new Vol();
		
		private String selectedAeroportDepartId= null;
		private String selectedAeroportArriveeId= null;
		
		
		private String selectedCompanyId = null;
		private String selectedAvionId = null;
		// Proxy
		@EJB
		private VolServiceLocal volServiceLocal;

		public VolBean(){
			
			System.out.println("CONSTRUCT depart = "+selectedAeroportDepartId+" Arrivee ="+selectedAeroportArriveeId+" company = "+selectedCompanyId+" Avion = "+selectedAvionId);
		}
		
		// Methods
		public String doAddVol(){
			try{
			//System.out.println("date depart ="+ vol.getDateDepart().toString());
			System.out.println("depart = "+selectedAeroportDepartId+" Arrivee ="+selectedAeroportArriveeId+" company = "+selectedCompanyId+" Avion = "+selectedAvionId);
			//avions = volServiceLocal.findAvionsByCompany(Integer.parseInt(selectedCompanyId));
			System.out.println("avions List in AddVol ="+ avions.size());
			Aeroport depart = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportDepartId()));
			Aeroport arrivee = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportArriveeId()));
			Avion avion = volServiceLocal.findAvionById(Integer.parseInt(selectedAvionId));
			
			vol.setAvion(avion);
			vol.setDepart(depart);
			vol.setArrivee(arrivee);
			//vol.setPlaces(null);
			
			volServiceLocal.addVol(vol);
			
			// reset the viewScoped 
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
			
			}catch(Exception e){
				System.err.println(e);
			}
			return "";
		}
		
		public String doUpdateVol(){
		
			try{
			//Aeroport depart = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportDepartId()));
			//Aeroport arrivee = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportArriveeId()));
			/*selectedVol.setDepartAeroport(depart);
			selectedVol.setArriveeAeroport(arrivee);
			*/
			
			//System.out.println("date depart ="+ vol.getDateDepart().toString());
			System.out.println("UPDATE depart = "+selectedAeroportDepartId+" Arrivee ="+selectedAeroportArriveeId+" company = "+selectedCompanyId+" Avion = "+selectedAvionId);
			//avions = volServiceLocal.findAvionsByCompany(Integer.parseInt(selectedCompanyId));
			
			Aeroport depart = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportDepartId()));
			Aeroport arrivee = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportArriveeId()));
			//Avion avion = volServiceLocal.findAvionById(Integer.parseInt(selectedAvionId));
			
			//selectedVol.setAvion(avion);
			selectedVol.setDepart(depart);
			selectedVol.setArrivee(arrivee);
			
			
			volServiceLocal.updateVol(selectedVol);
		}catch(Exception e){
			System.err.println(e);
		}
			// reset the viewScoped 
			//

			return "";
		}
		
		public String doDeleteVol(){
			
			volServiceLocal.deleteVol(selectedVol);
			this.setVol(null);
			this.setSelectedVol(null);

			return "";
		}
		
		public List<Vol> getVols() {
			vols=volServiceLocal.getVols();
			return vols;
		}

		public void setVols(List<Vol> vols) {
			this.vols = vols;
		}

		public Vol getVol() {
			return vol;
		}

		public void setVol(Vol vol) {
			this.vol = vol;
		}

		public List<Aeroport> getAeroports() {
			aeroports = volServiceLocal.getAeroports();
			
			return aeroports;
		}

		public void setAeroports(List<Aeroport> aeroports) {
			this.aeroports = aeroports;
		}

		public List<Compagnie> getCompagnies() {
			compagnies = volServiceLocal.getCompagnies();
			return compagnies;
		}

		public void setCompagnies(List<Compagnie> compagnies) {
			this.compagnies = compagnies;
		}
		
		public List<Avion> getAvions() {
			
			if(selectedCompanyId!=null)
				avions = volServiceLocal.findAvionsByCompany(Integer.parseInt(selectedCompanyId));

			return avions;
			
		}

		public void setAvions(List<Avion> avions) {
			this.avions = avions;
		}


		public Vol getSelectedVol() {
			
			if(selectedVol.getDepart() != null){
				selectedAeroportDepartId = selectedVol.getDepart().getId().toString();
				System.out.println("Aero depart = "+selectedVol.getDepart().getNom());
			}
			if(selectedVol.getArrivee() != null){
				selectedAeroportArriveeId = selectedVol.getArrivee().getId().toString();
				System.out.println("Aero arrivee = "+selectedVol.getArrivee().getNom());
			}
			//if(selectedVol!=null && selectedVol.getDepart()!=null){
			/*	if(selectedVol!=null){
					this.setSelectedAeroportDepartId(selectedVol.getDepart().getId().toString());
					this.setSelectedAeroportArriveeId(selectedVol.getArrivee().getId().toString());
			//	}
	
			//if(selectedVol!=null && selectedVol.getAvion()!=null){
					this.setSelectedAvionId(selectedVol.getAvion().getId().toString());
					this.setSelectedCompanyId(selectedVol.getAvion().getCompagnie().getId().toString());
			//}
					return selectedVol;
				}
				*/
			return selectedVol;
		}

		public void setSelectedVol(Vol selectedVol) {
			this.selectedVol = selectedVol;
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

		public String getSelectedAeroportDepartId() {
			return selectedAeroportDepartId;
		}

		public void setSelectedAeroportDepartId(String selectedAeroportDepartId) {
			this.selectedAeroportDepartId = selectedAeroportDepartId;
		}

		public String getSelectedAeroportArriveeId() {
			return selectedAeroportArriveeId;
		}

		public void setSelectedAeroportArriveeId(String selectedAeroportArriveeId) {
			this.selectedAeroportArriveeId = selectedAeroportArriveeId;
		}

	
		/** Events **/
		 public void companyChangeListener(ValueChangeEvent event) {
		        if (event.getNewValue() != selectedCompanyId) {
		            selectedAvionId = null;
		        }
		        selectedCompanyId=event.getNewValue().toString();
		 }


		

}
