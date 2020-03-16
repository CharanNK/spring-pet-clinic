package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Ajay");
        owner1.setLastName("Bhat");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setFirstName("Goutham");
        owner1.setLastName("Godz");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Charan");
        owner3.setLastName("Shetty");

        ownerService.save(owner3);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sumanth");
        vet1.setLastName("Prabhu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gaurav");
        vet2.setLastName("Pai");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
