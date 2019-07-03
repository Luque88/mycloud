/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.Documento;
import com.mycloud.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;

/**
 *
 * @author tss
 */

@Stateless
public class DocumentoStore {
    
  
    @PersistenceContext
    EntityManager em;
    
    User logged;
    
    @PostConstruct
    public void init(){
        logged = em.find(User.class, 1l);
    }
    
    public List<Documento> all() {
        return em.createQuery("SELECT e FROM Documento e WHERE e.user= :usr")
                .setParameter("usr", logged)
                .getResultList();
    }
    
    public Documento find (Long id){
        return em.find(Documento.class, id);
    }
    
    public Documento save (Documento d, InputStream is){
       d.setUser(logged);
      Documento saved = em.merge(d);
      try{
        Files.copy(is, documentPath(saved.getFile()),
               StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ex) {
           throw new EJBException("save document failed...");
       }
      return saved;
    }
   
   public void delete (Long id){
       Documento saved = find(id);
       try{
          Files.delete(documentPath(saved.getFile()));
      }catch (IOException ex){
           throw new EJBException("delete document failed...");
       }
       em.remove(id);
   }
      
    private Path documentPath(String name){
        System.out.println("user: " + logged + " name: " + name);
        return Paths.get(Configuration.DOCUMENT_FOLDER +
                logged.getUsername() + "/" + name);
    }
    
    void removeByUser(Long id){
        throw new Unsupport tedOperationException("not supported yet.");
    }
}
