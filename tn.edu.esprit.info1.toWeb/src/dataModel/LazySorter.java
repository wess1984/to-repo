package dataModel;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import domain.CategorieChambre;

public class LazySorter implements Comparator<CategorieChambre> {

	private String sortField;
    
    private SortOrder sortOrder;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
   
	@SuppressWarnings("unchecked")
	@Override
	public int compare(CategorieChambre categChambre1, CategorieChambre categChambre2) {
		try {
            Object value1 = CategorieChambre.class.getField(this.sortField).get(categChambre1);
            Object value2 = CategorieChambre.class.getField(this.sortField).get(categChambre2);
 
            @SuppressWarnings("rawtypes")
			int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
	}

}
