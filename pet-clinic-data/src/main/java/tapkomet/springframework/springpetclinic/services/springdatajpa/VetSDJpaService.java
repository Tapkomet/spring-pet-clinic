package tapkomet.springframework.springpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.repositories.VetRepository;
import tapkomet.springframework.springpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tapkomet on 2/5/2020
 */
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<Vet>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
