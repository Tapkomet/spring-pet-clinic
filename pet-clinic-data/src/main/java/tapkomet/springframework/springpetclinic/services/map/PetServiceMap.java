package tapkomet.springframework.springpetclinic.services.map;

import tapkomet.springframework.springpetclinic.model.Pet;
import tapkomet.springframework.springpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
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
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}