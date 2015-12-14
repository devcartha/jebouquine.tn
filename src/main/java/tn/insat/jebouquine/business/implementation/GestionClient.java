package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionClient;
import tn.insat.jebouquine.business.facade.IGestionEditeur;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.repository.IClientRepository;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Component
@Transactional
public class GestionClient implements IGestionClient {
    @Autowired
    IClientRepository clientRepository;

    @Override
    public void addClient(Client c){
        clientRepository.save(c);
    }

    @Override
    public Client getClientById(Long id){
        return clientRepository.findOne(id);
    }

    @Override
    public Client getClientByLoginPassword(String login, String password) {
        return clientRepository.findClientByLoginAndPassword(login, password);
    }

    @Override
    public ArrayList<Client> getAll() {
        return (ArrayList<Client>) clientRepository.findAll();
    }

    @Override
    public ArrayList<Client> getClientsByKeyWord(String keyWord) {
        return (ArrayList<Client>) clientRepository.findClientByNomContainingOrPrenomContainingOrCinContainingOrNumeroPasseportContainingOrDateInscriptionContainingOrEmailContainingOrAdresseContainingOrLoginContaining
                (keyWord,keyWord,keyWord,keyWord,keyWord,keyWord,keyWord,keyWord);
    }
}
