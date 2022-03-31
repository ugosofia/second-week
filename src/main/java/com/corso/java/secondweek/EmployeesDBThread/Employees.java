package com.corso.java.secondweek.EmployeesDBThread;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Employees{

    private int id;
    private int name;
    private int lastname;


    public void print() {
        System.out.println("Employee id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Lastname: " + lastname);
    }




}