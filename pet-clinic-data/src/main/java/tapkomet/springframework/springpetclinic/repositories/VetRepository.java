package tapkomet.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import tapkomet.springframework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}
