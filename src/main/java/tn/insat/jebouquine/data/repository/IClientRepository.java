package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Client;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IClientRepository extends CrudRepository<Client,Long> {
    public Client findClientByLoginAndPassword(String login,String password);
    public Collection<Client> findClientByNomAndPrenom(String nom, String prenom);
    public Collection<Client> findClientByNomOrPrenom(String nom,String prenom);
    public Client findClientByCin(String cin);
    public Client findClientByNumeroPasseport(String cin);
    public Collection<Client> findClientByDateInscription(String dateInscription);
}
