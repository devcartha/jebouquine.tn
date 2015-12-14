package tn.insat.jebouquine.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.insat.jebouquine.business.facade.IGestionEditeur;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IEditeurRepository;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;

import java.util.ArrayList;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Component
@Transactional
public class GestionEditeur implements IGestionEditeur {
    @Autowired
    IEditeurRepository editeurRepository;
    @Autowired
    IOuvrageRepository ouvrageRepository;

    @Override
    public void addEditeur(Editeur c) {
        editeurRepository.save(c);
    }

    @Override
    public Editeur getEditeurById(Long id) {
        return editeurRepository.findOne(id);
    }

    @Override
    public ArrayList<Editeur> getAll() {
        return (ArrayList<Editeur>)editeurRepository.findAll();
    }

    @Override
    public void deleteEditeur(Long id) {
        Editeur e = editeurRepository.findOne(id);
        ArrayList<Ouvrage> ouvrages = ouvrageRepository.findOuvrageByEditeurNom(e.getNom());
        for (Ouvrage o : ouvrages){
            o.setEditeur(null);
            ouvrageRepository.save(o);
        }
        editeurRepository.save(e);
        editeurRepository.delete(e);
    }

    @Override
    public ArrayList<Editeur> getEditeurByKeyWord(String keyWord) {
        return (ArrayList<Editeur>)editeurRepository.findEditeurByNomContaining(keyWord);
    }
}
