package com.corso.java.secondweek.jpa.domain;


import javax.persistence.*;

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private String id;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

}
