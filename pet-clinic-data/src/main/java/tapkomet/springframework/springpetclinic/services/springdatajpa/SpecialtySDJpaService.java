package tapkomet.springframework.springpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Specialty;
import tapkomet.springframework.springpetclinic.repositories.SpecialtyRepository;
import tapkomet.springframework.springpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tapkomet on 2/5/2020
 */
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialtys = new HashSet<Specialty>();
        specialtyRepository.findAll().forEach(specialtys::add);
        return specialtys;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}