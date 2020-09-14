package springframework.silinde87petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.silinde87petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
