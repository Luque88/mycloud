/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.Documento;
import com.mycloud.entity.User;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
/**
 *
 * @author tss
 */
@RolesAllowed({"users"})
@Stateless
public class DocumentoStore {
    
  
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Principal principal;
    
    @Inject
    JsonWebToken token;
    
    @Inject
    UserStore userstore;
    
    @PostConstruct
    public void init(){
        
    }
     public List<Documento> all() {
        System.out.println("token user: " + token.getName());
        System.out.println("token email: " + token.getClaim(Claims.email.name()));
        return em.createQuery("select e from Documento e where e.user.usr= :usr")
                .setParameter("usr", principal.getName())
                .getResultList();
    }
    
public Documento find (Integer id){
    return em.find(Documento.class, id);
}


public Documento save (Documento d){
    return em.merge(d);
}
public void remove (Integer id){
    em.remove(find(id));
}

public Documento addDocumento (Documento d){
    return em.merge(d);
}

public Documento updateDocumento (Documento d){
    return em.merge(d);
}

public List<Documento> findByUser(Integer userId){
    return em.createQuery("SELECT d FROM d WHERE d.user.id= :user_id ORDER BY d.id", Documento.class).setParameter("user_id", userId).getResultList();
}

public List<Documento> findAll() {
		return em.createQuery("SELECT d FROM Documento d ORDER BY d.id", Documento.class).getResultList();
	}

	public List<Documento> documenti(Integer id) {
		return em.createQuery("SELECT d.documenti FROM Documento d WHERE d.id", Documento.class).setParameter("id", id)
				.getResultList();

	}

 
    }

  
    

   

      

    

    
   

 
      
        

   