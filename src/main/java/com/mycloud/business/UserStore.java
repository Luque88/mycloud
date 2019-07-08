/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.User;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
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
 
 
        public Optional<User> login(String usr, String pwd) {
        try {
            User p = em.createQuery("select e from User e "
                    + "where e.usr= :usr and e.pwd= :pwd", User.class)
                    .setParameter("usr", usr)
                    .setParameter("pwd", pwd)
                    .getSingleResult();
            return Optional.of(p);
        } catch (NoResultException | NonUniqueResultException ex) {
            return Optional.empty();
        }
      }
    
    
    
    
    public User find (Integer id){
        return em.find(User.class, id);
    }
    
    public User save (User u){
        return em.merge(u);
    }
    
    public void remove(Integer id){
        em.remove(find(id));
    }
    
    public User addUser(User u){
        return em.merge(u);
    }
    
    public User updateUser(User u){
        return em.merge(u);
    }
    
    public User findId (Integer id){
        return em.find(User.class, id);
    }
   
  public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
	}
  
  public Optional <User> findByUser(String usr){
      try{
      User p= em.createQuery("SELECT u FROM User u" + "WHERE u.usr= :usr", User.class)
              .setParameter("usr", usr)
              .getSingleResult();
      return Optional.of(p);
      }catch(NoResultException | NonUniqueResultException ex){
          return Optional.empty();
      }  
  }
}
