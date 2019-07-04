/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.User;
import java.util.Optional;
import javax.ejb.Stateless;
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
   
  
}