package springframework.silinde87petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.silinde87petclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTypeServiceMapTest {

    PetTypeServiceMap petTypeServiceMap;

    final Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeServiceMap();

        petTypeServiceMap.save(PetType.builder().build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = petTypeServiceMap.findAll();

        assertEquals(1, petTypeSet.size());
    }

    @Test
    void findById() {
        PetType petType = petTypeServiceMap.findById(petTypeId);

        assertEquals(petTypeId, petType.getId());
    }

    @Test
    void save() {
        PetType petType2 = PetType.builder().build();

        PetType savedPetType = petTypeServiceMap.save(petType2);

        assertEquals(2L, savedPetType.getId());
    }

    @Test
    void delete() {
        petTypeServiceMap.delete(petTypeServiceMap.findById(petTypeId));

        assertEquals(0, petTypeServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(petTypeId);

        assertEquals(0, petTypeServiceMap.findAll().size());
    }
}