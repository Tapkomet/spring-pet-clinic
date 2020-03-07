package tapkomet.springframework.springpetclinic.services;

import tapkomet.springframework.springpetclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long>   {
    PetType findByName(String name);
}
