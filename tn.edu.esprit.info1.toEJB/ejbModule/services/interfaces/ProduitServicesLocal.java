package services.interfaces;

import javax.ejb.Local;

import domain.Produit;

@Local
public interface ProduitServicesLocal {

	Boolean addProduct(Produit produit);
}
