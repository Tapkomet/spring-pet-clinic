package tapkomet.springframework.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tapkomet.springframework.springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private final Long OWNER_ID = 1L;
    private final String OWNER_LAST_NAME = "testName";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void saveWithId() {
        Owner owner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build();
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
        Owner foundOwner = ownerMapService.findById(OWNER_ID);
        assertEquals(OWNER_ID, foundOwner.getId());

    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerMapService.findByLastName(OWNER_LAST_NAME);
        assertEquals(OWNER_LAST_NAME, foundOwner.getLastName());
    }

    @Test
    void findNullByLastName() {
        Owner foundOwner = ownerMapService.findByLastName("foo");
        assertNull(foundOwner);
    }
}