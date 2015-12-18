package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionCommande;
import tn.insat.jebouquine.data.entity.*;
import tn.insat.jebouquine.data.repository.IClientRepository;
import tn.insat.jebouquine.data.repository.ICommandeRepository;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Devcartha on 12/17/2015.
 */
@Component
@Transactional
public class GestionCommande implements IGestionCommande{

    @Autowired
    ICommandeRepository commandeRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IOuvrageRepository ouvrageRepository;

    @Override
    public Commande passerCommande(Panier panier) {

        Client client = clientRepository.findOne(panier.getClient().getId());

        Commande commande = new Commande();

        for (LigneCommande lc : panier.getLignesCommande()){
            Ouvrage ouvrage = ouvrageRepository.findOne(lc.getOuvrage().getId());
            ouvrage.setQuantiteDispo(ouvrage.getQuantiteDispo()-lc.getQuantite());
            ouvrage.setQuantiteVendus(ouvrage.getQuantiteVendus()+lc.getQuantite());
            lc.setOuvrage(ouvrage);
            lc.setCommande(commande);
            commande.setTotal(commande.getTotal()+lc.getPrix());
        }

        commande.setEtat("En cours");
        commande.setDateCommande(new Date());
        commande.setAdresseLivraison(client.getAdresse());
        commande.setModePaiement("Chéque/Espèce");

        commande.setLignesCommande(panier.getLignesCommande());
        commande.setClient(client);

        commandeRepository.save(commande);
        return commande;
    }

    @Override
    public ArrayList<Commande> getAll() {
        return (ArrayList<Commande>) commandeRepository.findAll();
    }

    @Override
    public ArrayList<Commande> getEditeurByKeyWord(String keyWord) {
        return commandeRepository.findCommandeByClientNomContainingOrClientPrenomContainingOrEtatContainingOrDateCommandeOrLignesCommandeOuvrageTitreContainingOrAdresseLivraisonContainingOrModePaiementContaining
                (keyWord, keyWord, keyWord, keyWord, keyWord, keyWord, keyWord);
    }
}
