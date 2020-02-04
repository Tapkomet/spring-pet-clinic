package tapkomet.springframework.springpetclinic.services;

import tapkomet.springframework.springpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
