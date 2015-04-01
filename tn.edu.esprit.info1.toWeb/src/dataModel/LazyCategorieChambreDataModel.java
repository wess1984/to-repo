package dataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import domain.CategorieChambre;

@SuppressWarnings("serial")
public class LazyCategorieChambreDataModel extends LazyDataModel<CategorieChambre> {
	
	private List<CategorieChambre> datasource;
    
    public LazyCategorieChambreDataModel(List<CategorieChambre> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public CategorieChambre getRowData(String rowKey) {
        for(CategorieChambre categChambre : datasource) {
            if(categChambre.getId().equals(rowKey))
                return categChambre;
        } 
        return null;
    }
    
    @Override
    public Object getRowKey(CategorieChambre categChambre) {
        return categChambre.getId();
    }
    
    @Override
    public List<CategorieChambre> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<CategorieChambre> data = new ArrayList<CategorieChambre>();
 
        //filter
        for(CategorieChambre categChambre : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(categChambre.getClass().getField(filterProperty).get(categChambre));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(categChambre);
            }
        }
 
        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
