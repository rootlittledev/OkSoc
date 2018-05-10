package com.ethero.quest.resources;

import com.ethero.quest.models.User;
import com.ethero.quest.resources.Beans.UserFilter;
import com.ethero.quest.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService = new UserService();

    @GET
    public List<User> getUsers(@BeanParam UserFilter userFilter){

        if (userFilter.getAge() > 0){
            return userService.getUsersByAge(userFilter.getAge());
        }

        if (userFilter.getName() != null){
            return userService.getUsersByName(userFilter.getName());
        }

        if (userFilter.getGender() != null){
            return userService.getUsersByGender(userFilter.getGender());
        }




        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") long id){
        return userService.getUser(id);
    }

    @POST
    @Path("/add")
    public User addUser(User user){
        userService.addUser(user);
        return user;
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") long id, User user){
        userService.updateUser(user, id);
        return user;
    }

}
