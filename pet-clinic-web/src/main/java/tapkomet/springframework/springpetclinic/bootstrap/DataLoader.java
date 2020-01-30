package tapkomet.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tapkomet.springframework.springpetclinic.model.*;
import tapkomet.springframework.springpetclinic.services.*;

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
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty savedRadiology = specialtyService.save(radiology);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(dentistry);
        vet2.getSpecialties().add(surgery);

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
