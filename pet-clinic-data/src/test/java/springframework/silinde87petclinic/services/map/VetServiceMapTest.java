package springframework.silinde87petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.silinde87petclinic.model.Speciality;
import springframework.silinde87petclinic.model.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetServiceMapTest {

    VetServiceMap vetServiceMap;

    final Long vetId = 1L;
    final Set<Speciality> specialitySet = new HashSet<>();


    @BeforeEach
    void setUp() {
        vetServiceMap = new VetServiceMap(new SpecialityServiceMap());

        vetServiceMap.save(Vet.builder().specialities(specialitySet).build());
    }

    @Test
    void findAll() {
        Set<Vet> vetSet = vetServiceMap.findAll();

        assertEquals(1, vetSet.size());
    }

    @Test
    void findById() {
        Vet vet = vetServiceMap.findById(vetId);

        assertEquals(vetId, vet.getId());
    }

    @Test
    void save() {
        Long id = 2L;

        Vet vet2 = Vet.builder().specialities(specialitySet).build();

        Vet savedVet = vetServiceMap.save(vet2);

        assertEquals(id, savedVet.getId());
    }

    @Test
    void delete() {
        vetServiceMap.delete(vetServiceMap.findById(vetId));

        assertEquals(0, vetServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(vetId);

        assertEquals(0,vetServiceMap.findAll().size());
    }
}