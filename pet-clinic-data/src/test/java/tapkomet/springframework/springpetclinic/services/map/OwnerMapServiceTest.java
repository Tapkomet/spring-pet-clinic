package tapkomet.springframework.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tapkomet.springframework.springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String ownerLastName = "testName";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void saveWithId() {
        Owner owner = Owner.builder().id(ownerId).lastName(ownerLastName).build();
        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(owner, savedOwner);
    }

    @Test
    void saveWithoutId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner foundOwner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, foundOwner.getId());

    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerMapService.findByLastName(ownerLastName);
        assertEquals(ownerLastName, foundOwner.getLastName());
    }

    @Test
    void findNullByLastName() {
        Owner foundOwner = ownerMapService.findByLastName("foo");
        assertNull(foundOwner);
    }
}