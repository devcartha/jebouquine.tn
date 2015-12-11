package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Ouvrage;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/10/2015.
 */
public interface IGestionOuvrage {
    public void addOuvrage(Ouvrage ouvrage);
    public ArrayList<Ouvrage> getAll();
}
