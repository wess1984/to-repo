package tn.edu.esprit.info1.toWeb;


import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;




import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Aeroport;
import services.interfaces.VolServiceLocal;

@ManagedBean
@ViewScoped
@FacesConverter(forClass=Aeroport.class)
public class AeroportConverter implements Converter {

	private static final Logger log = Logger.getLogger( AeroportConverter.class.getName() );
	
	@EJB
	VolServiceLocal volServiceLocal;
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		
		if (value == null || value.isEmpty()) {
            return null;
        }

        try {
        	
            Object obj =  volServiceLocal.findAeroportById(Integer.valueOf(value));
            log.warning("Aeroport ="+((Aeroport)obj).getNom());
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Aeoroport", value)), e);
        }
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		 if (!(value instanceof Aeroport)) {
             return null;
         }
        String s =  String.valueOf(((Aeroport) value).getId());
        return s;
	}

}
