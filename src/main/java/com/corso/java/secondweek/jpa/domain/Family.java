package com.corso.java.secondweek.jpa.domain;


import javax.persistence.*;

public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_id")
    private String id;

    @Column(length = 30)
    private String Description;

    @OneToMany
    @JoinColumn(name = "person_id")
    private Person person;

}
