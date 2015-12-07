package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Avi;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IAviRepository extends CrudRepository<Avi,Long> {
}
