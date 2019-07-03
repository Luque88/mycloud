/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.services;

import com.mycloud.business.DocumentoStore;
import com.mycloud.entity.Documento;
import java.io.InputStream;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Path("/documents")
public class DocumentiResource {
    
    
    @Inject
    DocumentoStore store;
    
    @GET
    public List<Documento> findAll(){
        return store.all();
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream is,
            @FormDataParam("file") FormDataContentDisposition cdh,
            @FormDataParam("titolo") String titolo){
        
        Documento doc = new Documento ();
        doc.setTitolo(titolo);
        doc.setFileName(cdh.getFileName());
        store.save(doc,is);
        return Response.status(200).build();
    }
}
