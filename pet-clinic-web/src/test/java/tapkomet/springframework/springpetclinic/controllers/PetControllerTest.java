package tapkomet.springframework.springpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tapkomet.springframework.springpetclinic.model.Owner;
import tapkomet.springframework.springpetclinic.model.Pet;
import tapkomet.springframework.springpetclinic.model.PetType;
import tapkomet.springframework.springpetclinic.services.OwnerService;
import tapkomet.springframework.springpetclinic.services.PetService;
import tapkomet.springframework.springpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    PetService petService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController controller;

    private Set<Owner> owners;
    private Set<PetType> petTypes;
    private Set<Pet> pets;

    private final Long ID = 1L;
    private final Long ID2 = 2L;
    private final String OWNER_LAST_NAME = "testName";
    private final Owner testOwner = Owner.builder().id(ID).lastName(OWNER_LAST_NAME).build();

    private final String PET_NAME = "Ball";
    private final Pet testPet = Pet.builder().id(ID).name(PET_NAME).build();

    private final String PET_TYPE_NAME = "dog";
    private final PetType testPetType = PetType.builder().id(ID).name(PET_TYPE_NAME).build();
    private final String PET_TYPE_NAME2 = "cat";
    private final PetType testPetType2 = PetType.builder().id(ID2).name(PET_TYPE_NAME2).build();

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(testOwner);

        petTypes = new HashSet<>();
        petTypes.add(testPetType);
        petTypes.add(testPetType2);

        pets = new HashSet<>();
        pets.add(testPet);

        testOwner.setPets(pets);
        testPet.setOwner(testOwner);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(ownerService.findById(anyLong())).thenReturn(testOwner);
        when(petTypeService.findAll()).thenReturn(petTypes);
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("types"));

        verifyNoInteractions(petService);
    }

    @Test
    void processCreationForm() throws Exception {
        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
        verify(petService).save(any());
    }

    @Test
    void initUpdatePetForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(testPet);

        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("types"));
        verifyNoMoreInteractions(petService);
    }

    @Test
    void processUpdatePetForm() throws Exception {
        when(petService.save(any())).thenReturn(testPet);

        mockMvc.perform(post("/owners/1/pets/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("pet"));

        verify(petService).save(any());
    }
}