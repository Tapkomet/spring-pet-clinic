package tapkomet.springframework.springpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tapkomet.springframework.springpetclinic.model.Owner;
import tapkomet.springframework.springpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    private final Long OWNER_ID = 1L;
    private final String OWNER_LAST_NAME = "testName";
    private final Owner testOwner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build();

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(testOwner);
        owners.add(Owner.builder().build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners/index "))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(ownerService);
    }
}