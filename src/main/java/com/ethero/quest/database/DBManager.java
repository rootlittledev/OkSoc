package com.ethero.quest.database;

import com.ethero.quest.models.Interests;
import com.ethero.quest.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private EntityManager manager;

    public DBManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBConfig");
        manager = factory.createEntityManager();

        manager.getTransaction().begin();

      /*List<String> interests = new ArrayList<>();
        List<String> subInterests = new ArrayList<>();

        interests.add("Programming");
        interests.add("Music");

        subInterests.add("hiking");
        subInterests.add("biking");

        Interests interest = new Interests(interests, subInterests);

        manager.persist(new User(20, "Oleg", "Hutsulyak", "sawe", "waaaaww", "male", interest));

        manager.getTransaction().commit();*/
        /*manager.close();
        factory.close();*/

    }



    public EntityManager getManager() {
        return manager;
    }
}
