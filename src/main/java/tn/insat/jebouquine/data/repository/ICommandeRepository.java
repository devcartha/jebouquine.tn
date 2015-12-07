package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Commande;
import tn.insat.jebouquine.data.entity.Ouvrage;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface ICommandeRepository extends CrudRepository<Commande,Long> {
    public Collection<Commande> findCommandeByClient(Client c);
    public Collection<Commande> findCommandeByEtat(String etat);
    public Collection<Commande> findCommandeByDateCommande(String dateCommande);
    public Collection<Commande> findCommandeByLignesCommandeOuvrage(Ouvrage o);
}
