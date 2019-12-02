package tapkomet.springframework.springpetclinic.services.map;

import tapkomet.springframework.springpetclinic.model.Owner;
import tapkomet.springframework.springpetclinic.services.OwnerService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/15/2019
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
