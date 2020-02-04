package tapkomet.springframework.springpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tapkomet on 1/29/2020
 */
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
