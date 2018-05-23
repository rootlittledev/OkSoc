package com.ethero.quest.services;

import com.ethero.quest.database.DBManager;
import com.ethero.quest.exception.DataNotFoundException;
import com.ethero.quest.models.Interests;
import com.ethero.quest.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class InterstsService {

    private DBManager dbManager = new DBManager();

    public Interests getInterests(long id){
        String sqlQuery = "select user from com.ethero.quest.models.User user where user.id = :id";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("id", id);

        User user;

        try{
            user = queryResult.getSingleResult();
        }catch (RuntimeException e){
            throw new DataNotFoundException("User with id: " + id + " does not exist");
        }

        return user.getInterests();


    }

    public void addInterests(long id, Interests interests){

        String sqlQuery = "select user from com.ethero.quest.models.User user where user.id = :id";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("id", id);

        User user;

        try{
            user = queryResult.getSingleResult();
        }catch (RuntimeException e){
            throw new DataNotFoundException("User with id: " + id + " does not exist");
        }

        user.setInterests(interests);
    }
}
