package tapkomet.springframework.springpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Pet;
import tapkomet.springframework.springpetclinic.repositories.PetRepository;
import tapkomet.springframework.springpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tapkomet on 2/5/2020
 */
@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<Pet>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
