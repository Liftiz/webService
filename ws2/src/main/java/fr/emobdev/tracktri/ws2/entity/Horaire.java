/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Horaire.findAll", query = "SELECT h FROM Horaire h"),
    @NamedQuery(name = "Horaire.findByIdobjet", query = "SELECT h FROM Horaire h WHERE h.idobjet = :idobjet"),
    @NamedQuery(name = "Horaire.findByHeure", query = "SELECT h FROM Horaire h WHERE h.heure = :heure"),
    @NamedQuery(name = "Horaire.findByJours", query = "SELECT h FROM Horaire h WHERE h.jours = :jours")})
public class Horaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idobjet;
    @Temporal(TemporalType.TIME)
    private Date heure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    private String jours;
    @JoinColumns({
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false),
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Objet objet;

    public Horaire() {
    }

    public Horaire(Integer idobjet) {
        this.idobjet = idobjet;
    }

    public Horaire(Integer idobjet, String jours) {
        this.idobjet = idobjet;
        this.jours = jours;
    }

    public Integer getIdobjet() {
        return idobjet;
    }

    public void setIdobjet(Integer idobjet) {
        this.idobjet = idobjet;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getJours() {
        return jours;
    }

    public void setJours(String jours) {
        this.jours = jours;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjet != null ? idobjet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.idobjet == null && other.idobjet != null) || (this.idobjet != null && !this.idobjet.equals(other.idobjet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Horaire[ idobjet=" + idobjet + " ]";
    }
    
}
