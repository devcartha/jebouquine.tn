package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Editeur;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
public interface IGestionEditeur {
    public void addEditeur(Editeur c);
    public Editeur  getEditeurById(Long id);
    public ArrayList<Editeur > getAll();
    public void deleteEditeur(Long id);
    public ArrayList<Editeur> getEditeurByKeyWord(String keyWord);
}
