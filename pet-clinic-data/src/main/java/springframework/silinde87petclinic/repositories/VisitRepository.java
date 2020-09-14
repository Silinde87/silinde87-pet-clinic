package springframework.silinde87petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.silinde87petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
