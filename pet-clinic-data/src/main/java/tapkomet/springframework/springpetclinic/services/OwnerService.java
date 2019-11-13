package tapkomet.springframework.springpetclinic.services;

import tapkomet.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
