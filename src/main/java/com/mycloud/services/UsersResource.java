/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.services;

import com.mycloud.business.UserStore;
import com.mycloud.entity.User;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/users")
public class UsersResource {
    
    @Inject
    UserStore userstore;
    
    @Context
    ResourceContext rc;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"users"})
   public List<User> getUsers(){
       
       List<User> listOfUsers = userstore.findAll();
       return listOfUsers;
   }
    
    
   @GET
   @Path("/{id}")
   @RolesAllowed({"users"})
   @Produces(MediaType.APPLICATION_JSON)
   public User getUserById(@PathParam("id")int id){
       return userstore.findId(id);
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public User addUser (User u) {
       return userstore.addUser(u);
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public User updateUser(User u){
       return userstore.updateUser(u);
   }
   
   @DELETE
   @Path("/{id}")
   @RolesAllowed({"users"})
   @Produces(MediaType.APPLICATION_JSON)
   public void remove (@PathParam("id")int id){
       userstore.remove(id);
   }
}
