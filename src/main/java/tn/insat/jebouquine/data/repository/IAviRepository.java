package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Client;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IAviRepository extends CrudRepository<Avi,Long> {
    public Collection<Avi> findAviByClient(Client c);
    public Collection<Avi> findAviByOuvrage(Client c);
    public Collection<Avi> findAviByNote(int note);
}
