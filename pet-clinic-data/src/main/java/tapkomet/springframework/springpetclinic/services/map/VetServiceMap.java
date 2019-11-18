package tapkomet.springframework.springpetclinic.services.map;

import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
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
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}