package tn.insat.jebouquine.presentation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IAuteurRepository;
import tn.insat.jebouquine.data.repository.ICategorieRepository;
import tn.insat.jebouquine.data.repository.IEditeurRepository;


/**
 * Created by Devcartha on 12/11/2015.
 */
@Component
public class OuvrageValidator implements Validator {

    @Autowired
    IAuteurRepository auteurRepository;
    @Autowired
    ICategorieRepository categorieRepository;
    @Autowired
    IEditeurRepository editeurRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Ouvrage.class.isAssignableFrom(aClass);
    }
    @Override
    public void validate(Object o, Errors errors) {

        String auteurs="";
        for(Auteur a: ((Ouvrage)o).getAuteurs()){
            if (auteurRepository.findAuteurByNom(a.getNom())==null)
                auteurs+=a.getNom()+" et ";
        }
        if(auteurs.length()>0)
        errors.rejectValue("auteurs", "auteur.inexistant",auteurs.substring(0,auteurs.lastIndexOf("et"))+" n'existe(nt) pas dans la bases de données");

        String categories="";
        for(Categorie c: ((Ouvrage)o).getCategories()){
            if (categorieRepository.findCategorieByTitre(c.getTitre())==null)
                categories+=c.getTitre()+" et ";
        }
        if(categories.length()>0)
            errors.rejectValue("categories", "categorie.inexistant",categories.substring(0,categories.lastIndexOf("et"))+" n'existe(nt) pas dans la bases de données");

        if(editeurRepository.findEditeurByNom(((Ouvrage)o).getEditeur().getNom())==null)
            errors.rejectValue("editeur", "editeur.inexistant",((Ouvrage)o).getEditeur().getNom()+" n'existe pas dans la bases de données");


    }
}
