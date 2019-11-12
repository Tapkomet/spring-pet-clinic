package tapkomet.springframework.springpetclinic.model;

/**
 * Created by Tapkomet on 10/20/2019
 */
public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
