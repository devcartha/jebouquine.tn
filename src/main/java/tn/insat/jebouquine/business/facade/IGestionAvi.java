package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Ouvrage;

/**
 * Created by Devcartha on 12/17/2015.
 */
public interface IGestionAvi {
    void addAvi(Avi avi, Ouvrage ouvrage, Client client);
}
