package tapkomet.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Pet;
import tapkomet.springframework.springpetclinic.services.PetService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
