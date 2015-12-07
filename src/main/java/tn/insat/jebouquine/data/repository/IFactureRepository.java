package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Facture;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IFactureRepository extends CrudRepository<Facture,Long> {
    public Collection<Facture> findFactureByEtat(String etat);
    public Collection<Facture> findFactureByDateFacturation(String dateFacturation);
}
