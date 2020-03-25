package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.*;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.PetTypeService;
import com.example.springpetclinic.services.SpecialityService;
import com.example.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int petCount = petTypeService.findAll().size();

        if(petCount==0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog1");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat1");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ajay");
        owner1.setLastName("Bhat");
        owner1.setAddress("123 Aravindanagar");
        owner1.setCity("Mysore");
        owner1.setTelephone("1234567890");

        Pet ajaysPet = new Pet();
        ajaysPet.setPetType(savedDogPetType);
        ajaysPet.setOwner(owner1);
        ajaysPet.setBirthDate(LocalDate.now());
        ajaysPet.setPetName("Ceasar");
        owner1.getPets().add(ajaysPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Goutham");
        owner2.setLastName("Godz");
        owner2.setAddress("85 Shamina Plaza");
        owner2.setCity("Bangalore");
        owner2.setTelephone("9087654321");

        Pet godzPet = new Pet();
        godzPet.setPetType(savedCatPetType);
        godzPet.setOwner(owner2);
        godzPet.setBirthDate(LocalDate.now());
        godzPet.setPetName("Godzilla");
        owner2.getPets().add(godzPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Charan");
        owner3.setLastName("Shetty");

        ownerService.save(owner3);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sumanth");
        vet1.setLastName("Prabhu");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gaurav");
        vet2.setLastName("Pai");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
