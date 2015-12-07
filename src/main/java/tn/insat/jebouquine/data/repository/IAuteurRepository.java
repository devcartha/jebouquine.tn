package tn.insat.jebouquine.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Ouvrage;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IAuteurRepository extends CrudRepository<Auteur,Long> {
    public Collection<Auteur> findAuteurByNomOrPrenom(String nom, String prenom);
    public Collection<Auteur> findAuteurByNomAndPrenom(String nom, String prenom);
    public Collection<Auteur> findAuteurByNationalite(String nationalite);
}
