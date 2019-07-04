/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.business;

import com.mycloud.entity.Documento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author tss
 */

@Stateless
public class DocumentoStore {
    
  
    @PersistenceContext
    EntityManager em;
    
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
   