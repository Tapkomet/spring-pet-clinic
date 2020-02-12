package tapkomet.springframework.springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tapkomet.springframework.springpetclinic.model.Owner;
import tapkomet.springframework.springpetclinic.repositories.OwnerRepository;
import tapkomet.springframework.springpetclinic.repositories.PetRepository;
import tapkomet.springframework.springpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private final Long OWNER_ID = 1L;
    private final String OWNER_LAST_NAME = "testName";
    private final Owner testOwner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build();

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        when(service.findByLastName(anyString())).thenReturn(testOwner);

        Owner owner = service.findByLastName(OWNER_LAST_NAME);

        assertEquals(testOwner, owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(testOwner);
        when(service.findAll()).thenReturn(owners);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        //when(service.findById(anyLong())).thenReturn(Optional.of(testOwner));
       //Owner owner = service.findById(OWNER_ID);

        //assertEquals(testOwner, owner);
    }


    @Test
    void save() {
        when(service.save(any())).thenReturn(testOwner);
        Owner savedOwner = service.save(testOwner);
        assertEquals(testOwner, savedOwner);
    }

    @Test
    void delete() {
        service.delete(testOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);
        verify(ownerRepository).deleteById(anyLong());
    }
}