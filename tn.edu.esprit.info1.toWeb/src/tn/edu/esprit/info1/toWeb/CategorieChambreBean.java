package tn.edu.esprit.info1.toWeb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;


import services.interfaces.ChambreServiceLocal;
import services.interfaces.HotelServiceLocal;
import domain.CategorieChambre;
import domain.CategorieChambreProduit;
import domain.Hotel;

@ManagedBean
@ViewScoped
public class CategorieChambreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{hotelBean}")
	private HotelBean hotelBean;	
	@EJB
	HotelServiceLocal hotelServiceLocal;
	@EJB
	ChambreServiceLocal chambreServiceLocal;
	
	private CategorieChambreProduit categorieChambreProduit =new CategorieChambreProduit();
	private Hotel selectedHotel;
	private List<CategorieChambreProduit> categorieChambreProduits;
	private List<CategorieChambre> categorieChambreProduitsNotUsed;

	
	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public Hotel getSelectedHotel() {
		selectedHotel= hotelBean.getSelectedHotel();
		return selectedHotel;
	}

	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	public List<CategorieChambreProduit> getCategorieChambreProduits() {
				
	    categorieChambreProduits= hotelServiceLocal.getCategoriesChambreByHotel(selectedHotel.getId());
		return categorieChambreProduits;

	}

	public void setCategorieChambreProduits(List<CategorieChambreProduit> categorieChambreProduits) {
		this.categorieChambreProduits = categorieChambreProduits;
	}

	public List<CategorieChambre> getCategorieChambreProduitsNotUsed() {	
		categorieChambreProduitsNotUsed = chambreServiceLocal.getAllWhereCategNotInHotel(selectedHotel.getId());
		return categorieChambreProduitsNotUsed;
	}

	public void setCategorieChambreProduitsNotUsed(List<CategorieChambre> categorieChambreProduitsNotUsed) {
		this.categorieChambreProduitsNotUsed = categorieChambreProduitsNotUsed;
	}

	public void onCellEdit(CellEditEvent event) {
		CategorieChambre oldValue = (CategorieChambre)event.getOldValue();
		CategorieChambre newValue = (CategorieChambre)event.getNewValue();
         System.out.println(oldValue.getLibelle());
         System.out.println(newValue.getLibelle());
        if(newValue != null && !newValue.equals(oldValue)) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue.getLibelle() + ", New:" + newValue.getLibelle());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
  
        }
    }	

	public void doAddCategorieChambre(){
		System.out.println("MyBean");
		//hotelServiceLocal.addCategorieChambre(getSelectedHotel(), categorieChambreProduit);
	}

	public CategorieChambreProduit getCategorieChambreProduit() {
		return categorieChambreProduit;
	}

	public void setCategorieChambreProduit(CategorieChambreProduit categorieChambreProduit) {
		this.categorieChambreProduit = categorieChambreProduit;
	}

	
	
}
