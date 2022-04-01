package com.corso.teoria.hibernate;

import com.corso.java.secondweek.utils.Logger;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Data
public class HibernateRunner {

    Transaction transaction;
    Logger L = Logger.getInstance();

    public void run(){
        SessionFactory sessionFactory = null;
        Session session;
        Logger L = Logger.getInstance();


        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();

    }

    public void persistPerson(Session session) {
      try {

          transaction = session.getTransaction();
          transaction.begin();

          Person p = new Person();

          p.setId(1);
          p.setName("Ugo");
          p.setLastname("Sofia");

          session.save(p);
          transaction.commit();

      } catch (Exception e){
          if(session.getTransaction().isActive())
              session.getTransaction().rollback();
          L.info(e.getMessage());

      }
    }
    public static void main(String[] args) {
        HibernateRunner hr = new HibernateRunner();
        hr.run();
    }
}
