package com.corso.java.secondweek.jpa.domain;

import com.corso.java.secondweek.utils.JPAUtils;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATest {

    private static final String log4jProperties = "/Users/ugosofia/eclipse-workspace/second-week/src/main/resources/";
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    private Query query;

    public void init(){
        PropertyConfigurator.configure(log4jProperties);
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction() {
        this.init();
        et = em.getTransaction();
        et.begin();

        Person person;
        Family family;

        query = em.createQuery("SELECT m FROM Person m");
    }

    public static void print() {

    }

    public static void main(String[] args) {

    }
}
