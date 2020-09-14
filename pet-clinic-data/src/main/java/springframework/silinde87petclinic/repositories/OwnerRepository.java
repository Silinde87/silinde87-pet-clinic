package springframework.silinde87petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.silinde87petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
