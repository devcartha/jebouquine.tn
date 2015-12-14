package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionAuteur;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IAuteurRepository;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Component
@Transactional
public class GestionAuteur implements IGestionAuteur{
    @Autowired
    IAuteurRepository auteurRepository;
    @Autowired
    IOuvrageRepository ouvrageRepository;

    @Override
    public void addAuteur(Auteur a) {
        auteurRepository.save(a);
    }

    @Override
    public Auteur getAuteurById(Long id) {
        return auteurRepository.findOne(id);
    }

    @Override
    public ArrayList<Auteur> getAll() {
        return (ArrayList<Auteur>) auteurRepository.findAll();
    }

    @Override
    public void deleteAuteur(Long id) {
        Auteur a = auteurRepository.findOne(id);
        ArrayList<Ouvrage> ouvrages = ouvrageRepository.findOuvrageByAuteursNom(a.getNom());
        for (Ouvrage o : ouvrages){
            o.getAuteurs().remove(a);
            ouvrageRepository.save(o);
        }
        auteurRepository.save(a);
        auteurRepository.delete(a);
    }

    @Override
    public ArrayList<Auteur> getAuteursByKeyWord(String keyWord) {
        return auteurRepository.findAuteurByNomContainingOrNationaliteContainingOrEmailContaining(keyWord,keyWord,keyWord);
    }

}
