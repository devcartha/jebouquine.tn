package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Categorie;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface ICategorieRepository extends CrudRepository<Categorie,Long> {
    public Categorie findCategorieByTitre(String titre);
}
