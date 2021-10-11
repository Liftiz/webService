/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Typeobj.findAll", query = "SELECT t FROM Typeobj t"),
    @NamedQuery(name = "Typeobj.findByIdtypeobj", query = "SELECT t FROM Typeobj t WHERE t.idtypeobj = :idtypeobj"),
    @NamedQuery(name = "Typeobj.findByDesc", query = "SELECT t FROM Typeobj t WHERE t.desc = :desc")})
public class Typeobj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idtypeobj;
    @Size(max = 255)
    private String desc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeobj")
    private Collection<Objet> objetCollection;

    public Typeobj() {
    }

    public Typeobj(Integer idtypeobj) {
        this.idtypeobj = idtypeobj;
    }

    public Integer getIdtypeobj() {
        return idtypeobj;
    }

    public void setIdtypeobj(Integer idtypeobj) {
        this.idtypeobj = idtypeobj;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Collection<Objet> getObjetCollection() {
        return objetCollection;
    }

    public void setObjetCollection(Collection<Objet> objetCollection) {
        this.objetCollection = objetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeobj != null ? idtypeobj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeobj)) {
            return false;
        }
        Typeobj other = (Typeobj) object;
        if ((this.idtypeobj == null && other.idtypeobj != null) || (this.idtypeobj != null && !this.idtypeobj.equals(other.idtypeobj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Typeobj[ idtypeobj=" + idtypeobj + " ]";
    }
    
}
