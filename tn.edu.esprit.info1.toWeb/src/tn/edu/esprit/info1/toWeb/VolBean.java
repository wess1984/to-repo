package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.log.Log;

import services.interfaces.VolServiceLocal;
import domain.Aeroport;
import domain.Vol;

@ManagedBean
@RequestScoped
public class VolBean implements Serializable {

		//Model
		public List<Vol> vols = new ArrayList<>();
		public List<Aeroport> aeroports = new ArrayList<>();
		private Vol vol = new Vol();
		private Vol selectedVol = new Vol();
		private String selectedAeroportDepartId=null;
		private String selectedAeroportArriveeId=null;
		// Proxy
		@EJB
		private VolServiceLocal volServiceLocal;

		
		
		// Methods
		public String doAddVol(){
			Aeroport depart = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportDepartId()));
			Aeroport arrivee = volServiceLocal.findAeroportById(Integer.parseInt(this.getSelectedAeroportArriveeId()));
			vol.setDepartAeroport(depart);
			vol.setArriveeAeroport(arrivee);
			
			volServiceLocal.addVol(vol);
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

		public Vol getSelectedVol() {
			if(selectedVol!=null && selectedVol.getDepartAeroport()!=null){
				this.setSelectedAeroportDepartId(selectedVol.getDepartAeroport().getId().toString());
				this.setSelectedAeroportArriveeId(selectedVol.getArriveeAeroport().getId().toString());
			}
			return selectedVol;
		}

		public void setSelectedVol(Vol selectedVol) {
			this.selectedVol = selectedVol;
		}

}
