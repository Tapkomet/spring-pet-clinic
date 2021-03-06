package tapkomet.springframework.springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tapkomet.springframework.springpetclinic.model.PetType;
import tapkomet.springframework.springpetclinic.services.PetTypeService;

import java.util.Set;

/**
 * Created by Tapkomet on 1/29/2020
 */
@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType findByName(String name) {
        return this.findAll()
                .stream()
                .filter(petType -> petType.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
