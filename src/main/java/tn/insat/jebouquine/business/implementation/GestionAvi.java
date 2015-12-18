package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionAvi;
import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IAviRepository;

/**
 * Created by Devcartha on 12/17/2015.
 */
@Component
@Transactional
public class GestionAvi implements IGestionAvi{

    @Autowired
    IAviRepository aviRepository;

    @Override
    public void addAvi(Avi avi, Ouvrage ouvrage, Client client) {
        avi.setClient(client);
        avi.setOuvrage(ouvrage);
        aviRepository.save(avi);
    }
}
