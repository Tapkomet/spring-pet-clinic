package tapkomet.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tapkomet.springframework.springpetclinic.model.Owner;
import tapkomet.springframework.springpetclinic.model.Pet;
import tapkomet.springframework.springpetclinic.model.PetType;
import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.services.OwnerService;
import tapkomet.springframework.springpetclinic.services.PetService;
import tapkomet.springframework.springpetclinic.services.PetTypeService;
import tapkomet.springframework.springpetclinic.services.VetService;

import java.time.LocalDate;

/**
 * Created by Tapkomet on 12/3/2019
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Kingston Street, 3");
        owner1.setCity("Manchester");
        owner1.setTelephone("1232131222");

        Pet cat1 = new Pet();
        cat1.setPetType(savedCatPetType);
        cat1.setOwner(owner1);
        cat1.setName("Bagheera");
        cat1.setBirthDate(LocalDate.now());

        Pet savedCatPet = petService.save(cat1);
        owner1.getPets().add(savedCatPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Baker Street, 5");
        owner2.setCity("London");
        owner2.setTelephone("5878725387");

        Pet dog1 = new Pet();
        dog1.setPetType(savedDogPetType);
        dog1.setOwner(owner2);
        dog1.setName("Jake");
        dog1.setBirthDate(LocalDate.now());

        owner2.getPets().add(dog1);

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
