package tapkomet.springframework.springpetclinic.model;

import java.util.Set;

/**
 * Created by Tapkomet on 10/20/2019
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
