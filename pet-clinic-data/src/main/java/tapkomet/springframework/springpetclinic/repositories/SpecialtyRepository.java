package tapkomet.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import tapkomet.springframework.springpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
