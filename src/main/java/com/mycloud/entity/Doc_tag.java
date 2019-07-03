/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloud.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tss
 */
public class Doc_tag implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="documento_id")
    private Integer documento;
    
    @Column(name="tag")
    private String tag;

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.documento);
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
        final Doc_tag other = (Doc_tag) obj;
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doc_tag{" + "documento=" + documento + ", tag=" + tag + '}';
    }
    
    
    
}
