/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.human.ecg;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Macedo
 */
@Entity
@Table(name = "ECG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecg.findAll", query = "SELECT e FROM Ecg e")
    , @NamedQuery(name = "Ecg.findByValue", query = "SELECT e FROM Ecg e WHERE e.value = :value")
    , @NamedQuery(name = "Ecg.findByTimestamp", query = "SELECT e FROM Ecg e WHERE e.timestamp = :timestamp")
    , @NamedQuery(name = "Ecg.findById", query = "SELECT e FROM Ecg e WHERE e.id = :id")})
public class Ecg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private int value;
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public Ecg() {
    }

    public Ecg(Integer id) {
        this.id = id;
    }

    public Ecg(Integer id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecg)) {
            return false;
        }
        Ecg other = (Ecg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.human.ecg.Ecg[ id=" + id + " ]";
    }
    
}
