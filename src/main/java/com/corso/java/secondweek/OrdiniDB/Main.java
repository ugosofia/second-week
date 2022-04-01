package com.corso.java.secondweek.OrdiniDB;

public class Main extends Thread{


    public static void main(String[] args) {

      OrderOperations ordiniOperations = new OrderOperations();
      PersonOperations personOperation = new PersonOperations();

      ordiniOperations.createTable();
      personOperation.createTable();

      ordiniOperations.insert();
      personOperation.insert();
      ordiniOperations.insert();
      personOperation.insert();

      personOperation.findbyprimarykey(1);
      ordiniOperations.findbyprimarykey(10);

      personOperation.close();
      ordiniOperations.close();








    }

}
