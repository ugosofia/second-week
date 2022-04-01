package com.corso.java.secondweek.OrdiniDB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @Builder @AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private String lastname;
    private int age;

}
