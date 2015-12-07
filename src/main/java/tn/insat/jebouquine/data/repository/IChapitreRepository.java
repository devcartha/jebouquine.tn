package tn.insat.jebouquine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.jebouquine.data.entity.Chapitre;

import java.util.Collection;

/**
 * Created by Devcartha on 12/7/2015.
 */
@Repository
public interface IChapitreRepository extends CrudRepository<Chapitre,Long> {
    public Collection<Chapitre> findChapitreByNom(String nom);
    public Collection<Chapitre> findChapitreByExtrait(String extrait);
}
