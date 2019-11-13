package tapkomet.springframework.springpetclinic.services;

import java.util.Set;

/**
 * Created by Tapkomet on 11/13/2019
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
