package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.DetailsEquipe;

@Repository
public interface DetailsEquipeRepository extends CrudRepository<DetailsEquipe,Long> {
}
