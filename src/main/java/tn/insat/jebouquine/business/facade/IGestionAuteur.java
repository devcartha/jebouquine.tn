package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Auteur;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
public interface IGestionAuteur {
    public void addAuteur(Auteur a);
    public Auteur getAuteurById(Long id);
    public ArrayList<Auteur> getAll();
    public void deleteAuteur(Long id);
    public ArrayList<Auteur> getAuteursByKeyWord(String keyWord);
}
