package springframework.silinde87petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.silinde87petclinic.model.Owner;
import springframework.silinde87petclinic.model.Pet;
import springframework.silinde87petclinic.model.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitServiceMapTest {

    VisitServiceMap visitServiceMap;

    final Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitServiceMap = new VisitServiceMap();

        Long ownerId = 1L;
        Long petId = 1L;
        Owner owner = Owner.builder().id(ownerId).build();
        Pet pet = Pet.builder().owner(owner).build();
        pet.setId(petId);

        visitServiceMap.save(Visit.builder().pet(pet).build());
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = visitServiceMap.findAll();

        assertEquals(1, visitSet.size());
    }

    @Test
    void findById() {
        Visit visit = visitServiceMap.findById(visitId);

        assertEquals(visitId, visit.getId());
    }

    @Test
    void save() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Pet pet2 = Pet.builder().owner(owner2).build();
        pet2.setId(id);
        Visit savedVisit = visitServiceMap.save(Visit.builder().pet(pet2).build());

        assertEquals(id, savedVisit.getId());
    }

    @Test
    void delete() {
        visitServiceMap.delete(visitServiceMap.findById(visitId));

        assertEquals(0, visitServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        visitServiceMap.deleteById(visitId);

        assertEquals(0, visitServiceMap.findAll().size());
    }
}