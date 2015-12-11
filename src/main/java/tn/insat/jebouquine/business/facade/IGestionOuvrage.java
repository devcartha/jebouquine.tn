package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.presentation.model.OuvrageModel;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Devcartha on 12/10/2015.
 */
public interface IGestionOuvrage {
    public HashMap<String,Object> ajoutOuvrage(OuvrageModel model);
    public void ajoutOuvrage(Ouvrage ouvrage);
}
