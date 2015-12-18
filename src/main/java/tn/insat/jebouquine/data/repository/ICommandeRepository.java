package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Commande;
import tn.insat.jebouquine.data.entity.Ouvrage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface ICommandeRepository extends CrudRepository<Commande,Long> {
    public ArrayList<Commande> findCommandeByClient(Client c);
    public ArrayList<Commande> findCommandeByEtat(String etat);
    public ArrayList<Commande> findCommandeByDateCommande(String dateCommande);
    public ArrayList<Commande> findCommandeByLignesCommandeOuvrage(Ouvrage o);
    public ArrayList<Commande> findCommandeByClientNomContainingOrClientPrenomContainingOrEtatContainingOrDateCommandeOrLignesCommandeOuvrageTitreContainingOrAdresseLivraisonContainingOrModePaiementContaining
            (String nom, String prenom, String etat, String date, String titre, String adresse, String modePaiement);
}
