package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IAuteurRepository;
import tn.insat.jebouquine.data.repository.ICategorieRepository;
import tn.insat.jebouquine.data.repository.IEditeurRepository;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/10/2015.
 */

@Component
@Transactional
public class GestionOuvrage implements IGestionOuvrage {

    @Autowired
    private IOuvrageRepository ouvrageRepository;
    @Autowired
    private IAuteurRepository auteurRepository;
    @Autowired
    private ICategorieRepository categorieRepository;
    @Autowired
    private IEditeurRepository editeurRepository;

    public void addOuvrage(Ouvrage ouvrage) {

        //Reattacher les objets à la session courante

        ArrayList<Categorie> categories = new ArrayList<>();
        for (Categorie c : ouvrage.getCategories()) {
            c = this.categorieRepository.findCategorieByTitre(c.getTitre());
            categories.add(c);
        }

        ArrayList<Auteur> auteurs = new ArrayList<>();
        for (Auteur a : ouvrage.getAuteurs()) {
            a = this.auteurRepository.findAuteurByNom(a.getNom());
            auteurs.add(a);
        }

        Editeur e = this.editeurRepository.findEditeurByNom(ouvrage.getEditeur().getNom());

        ouvrage.setEditeur(e);
        ouvrage.setCategories(categories);
        ouvrage.setAuteurs(auteurs);

        this.ouvrageRepository.save(ouvrage);
    }

    public ArrayList<Ouvrage> getAll(){
        return (ArrayList<Ouvrage>) ouvrageRepository.findAll();
    }
}
