package tapkomet.springframework.springpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tapkomet on 10/20/2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet extends BaseEntity {

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        if (visits != null) this.visits = visits;
    }

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<Visit>();

    public void addVisit(Visit visit) {
        this.visits.add(visit);
        visit.setPet(this);
    }

    public String toString() {
        return "Pet(id=" + this.getId() + "name=" + this.getName() + ", petType=" + this.getPetType() +
                ", owner=" + owner.getId() +
                ", birthDate=" + this.getBirthDate() + ", visits=" + this.getVisits() + ")";
    }
}
