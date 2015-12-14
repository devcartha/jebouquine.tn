package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.Client;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
public interface IGestionClient {
    void addClient(Client c);

    Client getClientById(Long id);
    Client getClientByLoginPassword(String login,String password);
    public ArrayList<Client> getAll();
    public ArrayList<Client> getClientsByKeyWord(String keyWord);
}
