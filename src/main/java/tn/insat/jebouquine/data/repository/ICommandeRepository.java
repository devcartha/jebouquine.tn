package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Commande;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface ICommandeRepository extends CrudRepository<Commande,Long> {
}
