package tapkomet.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.services.SpecialtyService;
import tapkomet.springframework.springpetclinic.services.VetService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object != null) {
            if (object.getSpecialties() != null) {
                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        //saves specialty with a generated id to persistence
                        specialtyService.save(specialty);
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
