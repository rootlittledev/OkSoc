package com.ethero.quest.database;

import com.ethero.quest.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {

    private EntityManager manager;

    public DBManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBConfig");
        manager = factory.createEntityManager();

        manager.getTransaction().begin();

        /*manager.persist(new User(20, "Volodymyr", "Mokrytskyi", "ethero", "qweqwe", "male"));
        manager.persist(new User(20, "Oleg", "Hutsulyak", "sawe", "waaaaww", "male"));
        manager.persist(new User(20, "Vasya", "Ukrainets", "vaso", "qweqwe", "male"));*/
        /*manager.close();
        factory.close();*/

    }



    public EntityManager getManager() {
        return manager;
    }
}
