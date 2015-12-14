package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionCategorie;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IAuteurRepository;
import tn.insat.jebouquine.data.repository.ICategorieRepository;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Component
@Transactional
public class GestionCategorie implements IGestionCategorie {
    @Autowired
    ICategorieRepository categorieRepository;
    @Autowired
    IOuvrageRepository ouvrageRepository;

    @Override
    public void addCategorie(Categorie c) {
        categorieRepository.save(c);
    }

    @Override
    public Categorie getCategorieById(Long id) {
        return categorieRepository.findOne(id);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return (ArrayList<Categorie>) categorieRepository.findAll();
    }

    @Override
    public void deleteCategorie(Long id) {
        Categorie c = categorieRepository.findOne(id);
        ArrayList<Ouvrage> ouvrages = ouvrageRepository.findOuvrageByCategoriesTitre(c.getTitre());
        for (Ouvrage o : ouvrages){
            o.getCategories().remove(c);
            ouvrageRepository.save(o);
        }
        categorieRepository.save(c);
        categorieRepository.delete(c);
    }

    @Override
    public Categorie getCategorieByTitre(String keyWord) {
        return categorieRepository.findCategorieByTitre(keyWord);
    }
}
