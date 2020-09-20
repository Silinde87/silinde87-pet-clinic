package springframework.silinde87petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.silinde87petclinic.model.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialityServiceMapTest {

    SpecialityServiceMap specialityServiceMap;
    final Long specialityId = 1L;

    @BeforeEach
    void setUp() {
        specialityServiceMap = new SpecialityServiceMap();

        specialityServiceMap.save(Speciality.builder().build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = specialityServiceMap.findAll();

        assertEquals(1, specialitySet.size());
    }

    @Test
    void findById() {
        Speciality speciality = specialityServiceMap.findById(specialityId);

        assertEquals(specialityId, speciality.getId());
    }

    @Test
    void save() {
        Speciality speciality2 = Speciality.builder().build();

        Speciality savedSpeciality = specialityServiceMap.save(speciality2);

        assertEquals(2, savedSpeciality.getId());
    }

    @Test
    void delete() {
        specialityServiceMap.delete(specialityServiceMap.findById(specialityId));

        assertEquals(0, specialityServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        specialityServiceMap.deleteById(specialityId);

        assertEquals(0, specialityServiceMap.findAll().size());
    }
}