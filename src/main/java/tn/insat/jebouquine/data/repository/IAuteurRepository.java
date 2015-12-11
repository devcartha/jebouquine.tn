package tn.insat.jebouquine.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Ouvrage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IAuteurRepository extends CrudRepository<Auteur,Long> {
    public Auteur findAuteurByNom(String nom);
    public ArrayList<Auteur> findAuteurByNationalite(String nationalite);
}
