package com.ethero.quest.services;

import com.ethero.quest.database.DBManager;
import com.ethero.quest.exception.DataNotFoundException;
import com.ethero.quest.models.User;
import com.ethero.quest.resources.UserResource;

import javax.persistence.TypedQuery;
import javax.ws.rs.core.UriInfo;
import java.util.List;

public class UserService {

    private DBManager dbManager = new DBManager();

    public void addUser(User user){
        dbManager.getManager().persist(user);
        dbManager.getManager().getTransaction().commit();
    }

    public void updateUser(User user, long id){
        user.setId(id);

        dbManager.getManager().merge(user);
        dbManager.getManager().getTransaction().commit();
    }

    public User getUser(long id){
        String sqlQuery = "select user from com.ethero.quest.models.User user where user.id = :id";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("id", id);

        User user;

        try{
            user = queryResult.getSingleResult();
        }catch (RuntimeException e){
            throw new DataNotFoundException("User with id: " + id + " does not exist");
        }

        return user;
    }

    public List<User> getUsers(){
        String sqlQuery = "select user from com.ethero.quest.models.User user";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);

        List<User> users = queryResult.getResultList();

        if (users.isEmpty()){
            throw new DataNotFoundException("There are no users yet");
        }

        return users;
    }

    public List<User> getUsersByAge(int age){
        String sqlQuery = "select user from User user where user.age = :age";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("age", age);

        List<User> users = queryResult.getResultList();

        if (users.isEmpty()){
            throw new DataNotFoundException("There are no " + age + " years old users");
        }

        return users;
    }

    public List<User> getUsersByGender(String gender){
        String sqlQuery = "select user from User user where user.gender = :gender";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("gender", gender);

        List<User> users = queryResult.getResultList();

        if (users.isEmpty()){
            throw new DataNotFoundException("There are no " + gender + " users");
        }

        return users;
    }

    public List<User> getUsersByName(String name){
        String sqlQuery = "select user from User user where user.name like :name";

        TypedQuery<User> queryResult = dbManager.getManager().createQuery(sqlQuery, User.class);
        queryResult.setParameter("name", "%" + name + "%");
        List<User> users = queryResult.getResultList();

        if (users.isEmpty()){
            throw new DataNotFoundException("There are no users named: " + name );
        }

        return users;
    }

    public String getUriSelf(UriInfo uriInfo, User user) {
        return uriInfo.getBaseUriBuilder()
                .path(UserResource.class)
                .path(Long.toString(user.getId()))
                .build()
                .toString();
    }

}
