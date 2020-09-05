package springframework.silinde87petclinic.services;

import springframework.silinde87petclinic.model.Pet;

import java.util.Set;

public interface PetService {



    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
