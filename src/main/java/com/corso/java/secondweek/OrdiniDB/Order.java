package com.corso.java.secondweek.OrdiniDB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @Builder @AllArgsConstructor
public class Order {

    private int orderID;
    private int nOrder;
    private int personID;

}
