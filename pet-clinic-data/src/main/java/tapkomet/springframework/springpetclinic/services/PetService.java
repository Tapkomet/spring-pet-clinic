package tapkomet.springframework.springpetclinic.services;

import tapkomet.springframework.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
