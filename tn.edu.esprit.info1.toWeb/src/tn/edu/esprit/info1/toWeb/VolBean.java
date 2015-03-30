package tn.edu.esprit.info1.toWeb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.log.Log;

import services.interfaces.VolServiceLocal;
import domain.Aeroport;
import domain.Vol;

@ManagedBean
@RequestScoped
public class VolBean {

	//Model
	public List<Vol> vols = new ArrayList<>();
	public List<Aeroport> aeroports = new ArrayList<>();
	private Vol vol = new Vol();

	// Proxy
	@EJB
	private VolServiceLocal volServiceLocal;

	// Methods
	public String doAddVol(){
		volServiceLocal.addVol(vol);
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


}
