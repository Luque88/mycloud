/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.services;

import com.mycloud.JWTManager;
import com.mycloud.business.UserStore;
import com.mycloud.entity.User;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.store;

/**
 *
 * @author tss
 */
@Path("/auth")
public class SecurityResource {
    
    @Inject
    UserStore userstore;
    
   @PermitAll
    @GET
    public Response login() {

        try {
            String token = JWTManager.generateJWTString("token.json");
            System.out.println("------------ generated token -------------------");
            System.out.println("------------ curl command for test -------------");
            System.out.println("curl -i -H'Authorization: Bearer " + token + "' http://localhost:8080/mycloud/resources/users");
        } catch (Exception ex) {
            Logger.getLogger(SecurityResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok().build();
    }

    @PermitAll
    @POST
    public Response login(@FormParam("usr") String usr, @FormParam("pwd") String pwd) {
        Optional<User> p = userstore.login(usr, pwd);
        p.ifPresent(a -> System.out.println(a.getNome()));
        JsonObject token = Json.createObjectBuilder().add("token",
                JWTManager.generateJWTString("token.json", p.get().getUsername())).build();
        return p.isPresent() ? Response.ok().entity(token).build()
                : Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
