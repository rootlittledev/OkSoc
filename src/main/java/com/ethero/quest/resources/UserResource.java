package com.ethero.quest.resources;

import com.ethero.quest.models.User;
import com.ethero.quest.resources.Beans.UserFilter;
import com.ethero.quest.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService = new UserService();

    @GET
    public List<User> getUsers(@BeanParam UserFilter userFilter){

        List<User> users = userService.getUsers();

        if (userFilter.getAge() > 0){
            users = userService.getUsersByAge(userFilter.getAge());
        }

        if (userFilter.getName() != null){
            users = userService.getUsersByName(userFilter.getName());
        }

        if (userFilter.getGender() != null){
            users = userService.getUsersByGender(userFilter.getGender());
        }

        for (User user : users) {
            user.addLink(userService.getUriSelf(userFilter.getUriInfo(), user), "self");
        }

        return users;
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") long id, @Context UriInfo uriInfo){
        User user = userService.getUser(id);

        String uri = userService.getUriSelf(uriInfo, user);

        user.addLink(uri, "self");

        return user;
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

    @GET
    @Path("/{id}/interests")
    public InterestsResource getInterests(){
        return new InterestsResource();
    }

}
