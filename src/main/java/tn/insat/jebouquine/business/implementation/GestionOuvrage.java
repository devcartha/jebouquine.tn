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
import tn.insat.jebouquine.presentation.model.OuvrageModel;

import java.util.ArrayList;
import java.util.HashMap;

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

    @Override
    public HashMap<String, Object> ajoutOuvrage(OuvrageModel model) {

        HashMap<String, Object> map = new HashMap<>();
        Ouvrage ouvrage = new Ouvrage(model.getTitre(), model.getIsbn(), model.getDateParution(), model.getImage(), model.getTableDeMatiere(), model.getQuantiteDispo(), 0);

        ArrayList<Categorie> categoriesA = new ArrayList<>();
        ArrayList<Auteur> auteursA = new ArrayList<>();

        String auteurs = model.getAuteurs();
        String[] listAuteurs;
        if (auteurs.contains(","))
            listAuteurs = auteurs.split(", ");
        else
            listAuteurs = new String[]{auteurs};

        for (String auteur : listAuteurs) {
            ArrayList<Auteur> listAuteur = (ArrayList<Auteur>) auteurRepository.findAuteurByNom(auteur);
            Auteur a = null;
            if (listAuteur.isEmpty()) {
                a = new Auteur();
                a.setNom(auteur);
                auteursA.add(a);
            }
            if (a != null)
                ouvrage.getAuteurs().add(a);
        }

        String categories = model.getCategories();
        String[] listCategories;
        if (categories.contains(","))
            listCategories = categories.split(", ");
        else
            listCategories = new String[]{categories};

        for (String categorie : listCategories) {
            Categorie c = categorieRepository.findCategorieByTitre(categorie);
            if (c == null) {
                c = new Categorie(categorie);
                categoriesA.add(c);
            }
            ouvrage.getCategories().add(c);
        }

        Editeur e = editeurRepository.findEditeurByNom(model.getEditeur());
        if (e == null) {
            e = new Editeur(model.getEditeur());
            map.put("editeur", e);
        }
        ouvrage.setEditeur(e);

        map.put("categories", categoriesA);
        map.put("auteurs", auteursA);

        if (map.isEmpty()) {
            ouvrageRepository.save(ouvrage);
            return map;
        }
        map.put("ouvrage", ouvrage);
        return map;
    }

    public void ajoutOuvrage(Ouvrage ouvrage) {

        //Reattacher les objets à la session courante

        ArrayList<Categorie> categories = new ArrayList<>();
        for (Categorie c : ouvrage.getCategories()) {
            if (c.getId() != null) {
                c = categorieRepository.findOne(c.getId());
            }
            categories.add(c);
        }

        ArrayList<Auteur> auteurs = new ArrayList<>();
        for (Auteur a : ouvrage.getAuteurs()) {
            if (a.getId() != null) {
                a = auteurRepository.findOne(a.getId());
            }
            auteurs.add(a);
        }

        Editeur e = ouvrage.getEditeur();
        if (ouvrage.getEditeur().getId() != null)
            e = editeurRepository.findOne(ouvrage.getEditeur().getId());

        ouvrage.setEditeur(e);
        ouvrage.setCategories(categories);
        ouvrage.setAuteurs(auteurs);

        ouvrageRepository.save(ouvrage);
    }
}
