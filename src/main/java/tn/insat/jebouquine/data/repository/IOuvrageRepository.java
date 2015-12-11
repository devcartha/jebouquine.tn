package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Ouvrage;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IOuvrageRepository extends CrudRepository<Ouvrage,Long> {
    public Ouvrage findOuvrageByIsbn(String ISBN);
    public Collection<Ouvrage> findOuvrageByDateParution(String date);
    public Collection<Ouvrage> findOuvrageByEditeurNom(String nom);
    public Collection<Ouvrage> findOuvrageByCategoriesTitre(String titre);
    public Collection<Ouvrage> findOuvrageByAuteursNom(String nom);
    public Collection<Ouvrage> findOuvrageByAuteursNationalite(String nationalite);
    public Collection<Ouvrage> findOuvrageByDateParutionContainingOrEditeurNomContainingOrCategoriesTitreContainingOrAuteursNomContainingOrAuteursNationaliteContaining(String date,String nomEditeur,String titreCategorie,String nomAuteur,String prenomAuteur,String nationaliteAuteur);
}
