package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Commande;
import tn.insat.jebouquine.data.entity.Panier;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/17/2015.
 */
public interface IGestionCommande {
    public Commande passerCommande(Panier panier);
    public ArrayList<Commande> getAll();
    ArrayList<Commande> getEditeurByKeyWord(String keyWord);
}
