package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Categorie;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
public interface IGestionCategorie {
    public void addCategorie(Categorie c);
    public Categorie getCategorieById(Long id);
    public ArrayList<Categorie> getAll();
    public void deleteCategorie(Long id);
    public Categorie getCategorieByTitre(String titre);
}
