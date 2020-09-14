package springframework.silinde87petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.silinde87petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
