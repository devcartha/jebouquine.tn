package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Client;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IAviRepository extends CrudRepository<Avi,Long> {
    public ArrayList<Avi> findAviByClient(Client c);
    public ArrayList<Avi> findAviByOuvrage(Client c);
    public ArrayList<Avi> findAviByNote(int note);
}
