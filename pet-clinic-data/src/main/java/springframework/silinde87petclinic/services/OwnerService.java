package springframework.silinde87petclinic.services;

import springframework.silinde87petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
