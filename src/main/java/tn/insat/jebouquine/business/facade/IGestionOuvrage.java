package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Ouvrage;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/10/2015.
 */
public interface IGestionOuvrage {
    public void addOuvrage(Ouvrage ouvrage);
    public ArrayList<Ouvrage> getAll();
    public Ouvrage getOuvrageById(Long id);
    public ArrayList<Avi> getAvisClients(Ouvrage ouvrage);
    public void deleteOuvrage(Long id);
    public ArrayList<Ouvrage> getOuvrageByKeyWord(String keyWord);
}
