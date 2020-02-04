package tapkomet.springframework.springpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tapkomet on 10/20/2019
 */
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
