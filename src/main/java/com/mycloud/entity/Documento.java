/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="documento")
public class Documento implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private Integer id;
    
    @Column (name="titolo")
    private String titolo;
    
    @Column (name="file")
    private String file;
    
    @JsonbTransient
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @ElementCollection
    @CollectionTable(
    name="doc_tag",
            joinColumns=@JoinColumn(name="documento_id", referencedColumnName="id")
    )
    
    @Column(name="tag")
    private List<String> tags = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(String user_id) {
        this.user = user;
    }

    public List<String> getTags(){
        return tags;
    }
    
    public void setTags(List<String> tags){
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Documento other = (Documento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documento{" + "id=" + id + ", titolo=" + titolo + ", file=" + file + ", user=" + user + ", tags=" + tags + '}';
    }


    
    
  
    
    
    
    
    
    
}
