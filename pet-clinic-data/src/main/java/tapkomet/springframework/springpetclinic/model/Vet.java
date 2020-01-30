package tapkomet.springframework.springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tapkomet on 10/20/2019
 */
public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
