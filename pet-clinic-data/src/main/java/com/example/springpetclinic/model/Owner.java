package com.example.springpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

public class Owner extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String lastName;

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
