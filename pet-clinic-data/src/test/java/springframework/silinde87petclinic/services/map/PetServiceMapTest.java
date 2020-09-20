package springframework.silinde87petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.silinde87petclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetServiceMapTest {

    PetServiceMap petServiceMap;

    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();

        petServiceMap.save(Pet.builder().build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petServiceMap.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void save() {
        Pet pet2 = Pet.builder().build();

        Pet savedPet = petServiceMap.save(pet2);

        assertEquals(2L, savedPet.getId());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(petId));

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petId);

        assertEquals(0, petServiceMap.findAll().size());
    }
}