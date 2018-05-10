package com.ethero.quest.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {

    private EntityManager manager;

    public DBManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBConfig");
        manager = factory.createEntityManager();

        manager.getTransaction().begin();

        /*manager.close();
        factory.close();*/

    }



    public EntityManager getManager() {
        return manager;
    }
}
