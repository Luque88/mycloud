/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.Configuration;
import com.mycloud.entity.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.SingularAttribute;
import javax.ws.rs.Path;

/**
 *
 * @author tss
 */
@Stateless
public class UserStore {

    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    DocumentoStore documentostore;
    
       public Optional<User> login (String usr, String pwd){
      
        try{
      User p =  em.createQuery("SELECT e FROM User e" 
              + "WHERE e.usr= :usr and e.pwd= :pwd", 
                  User.class)
                .setParameter("usr", usr)
                .setParameter("pwd", pwd)
                .getSingleResult();
      return Optional.of(p);
    }catch(NoResultException | NonUniqueResultException ex) {
        return Optional.empty();
        }
    }  
    
       
 public List <User> findAll(){
     return em.createQuery("SELECT e FROM User e ORDER BY e.cognome", User.class)
             .getResultList();
 }    
 
 public User find (Long id){
     return em.find(User.class, id);
 }
 
 public User save (User u){
     User saved = em.merge(u);
     Path path = Paths.get(Configuration.DOCUMENT_FOLDER + saved.getUsername());
     if(Files.notExists(path, LinkOption.NOFOLLOW_LINKS)){
         try {
             Files.createDirectory(path);
         } catch (IOException ex){
             throw new EJBException("save user failed");
         }
     }
     return saved;
 }
 
 public void remove (Long id){
    User saved = find(id);
    em.createQuery("delete from Documento e where e.user= :usr")
            .setParameter("usr", saved)
            .executeUpdate();
    em.remove(find(id));
    try {
        deleteDirectoryStream(Paths.get(Configuration.DOCUMENT_FOLDER + saved.getUsername()));
    } catch (IOException ex){
        throw new EJBException ("remove user failed...");
    }
 }
 
 private void deleteDirectoryStream(Path path) throw IOException {
     Files.walk(path)
             .sorted(Comparator.reverseOrder())
             .map(Path::toFile)
             .forEach(File::delete);
 }
}