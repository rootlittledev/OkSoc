package com.ethero.quest.resources;

import com.ethero.quest.models.Interests;
import com.ethero.quest.services.InterstsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InterestsResource {


    @GET
    public Interests getInterests(@PathParam("id") long id){
        InterstsService interests = new InterstsService();

        return interests.getInterests(id);
    }

    @POST
    @Path("add")
    public void addInterests(@PathParam("id") long id, Interests interest){
        InterstsService interests = new InterstsService();

        interests.addInterests(id, interest);
    }
}
