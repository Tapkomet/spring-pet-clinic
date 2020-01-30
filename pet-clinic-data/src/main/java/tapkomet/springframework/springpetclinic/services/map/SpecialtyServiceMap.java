package tapkomet.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.Specialty;
import tapkomet.springframework.springpetclinic.services.SpecialtyService;

import java.util.Set;

/**
 * Created by Tapkomet on 01/30/2019
 */
@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
