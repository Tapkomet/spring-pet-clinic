package tapkomet.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.services.VetService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
