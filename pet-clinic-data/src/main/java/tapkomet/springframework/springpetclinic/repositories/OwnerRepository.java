package tapkomet.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import tapkomet.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
