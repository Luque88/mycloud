/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.services;

import com.mycloud.business.DocumentoStore;
import com.mycloud.entity.Documento;
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
import javax.ws.rs.core.MediaType;
/**
 *
 * @author tss
*/

@RolesAllowed({"users"})
@Path("/documents")
public class DocumentiResource {
    
    
    @Inject
    DocumentoStore documentostore;
    
    
   @GET
   @Produces(MediaType.APPLICATION_JSON)
  
   public List<Documento> getDocumenti(){
       
      List<Documento> listOfDocumenti = documentostore.findAll();
       return listOfDocumenti;
   }
  
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Documento getDocumentoById(@PathParam("id") Integer id){
       return documentostore.find(id);
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public void addDocumento (Documento d){
       documentostore.addDocumento(d);
   }
   
   @PUT
   @Produces(MediaType.APPLICATION_JSON)
   public Documento updateDocumento(Documento d){
       return documentostore.updateDocumento(d);
   }
   
   @DELETE
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public void remove(@PathParam("id")Integer id){
       documentostore.remove(id);
   }

}
