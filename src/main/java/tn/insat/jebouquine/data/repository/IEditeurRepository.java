package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Editeur;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IEditeurRepository extends CrudRepository<Editeur,Long> {
    public Editeur findEditeurByNom(String nom);
}
