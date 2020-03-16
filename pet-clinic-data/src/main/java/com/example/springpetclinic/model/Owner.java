package com.example.springpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String lastName;
}
