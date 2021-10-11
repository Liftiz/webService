/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Locobj.findAll", query = "SELECT l FROM Locobj l"),
    @NamedQuery(name = "Locobj.findByIdobjet", query = "SELECT l FROM Locobj l WHERE l.locobjPK.idobjet = :idobjet"),
    @NamedQuery(name = "Locobj.findByIdadresse", query = "SELECT l FROM Locobj l WHERE l.locobjPK.idadresse = :idadresse")})
public class Locobj implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocobjPK locobjPK;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adresse adresse;
    @JoinColumns({
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false),
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Objet objet;

    public Locobj() {
    }

    public Locobj(LocobjPK locobjPK) {
        this.locobjPK = locobjPK;
    }

    public Locobj(int idobjet, int idadresse) {
        this.locobjPK = new LocobjPK(idobjet, idadresse);
    }

    public LocobjPK getLocobjPK() {
        return locobjPK;
    }

    public void setLocobjPK(LocobjPK locobjPK) {
        this.locobjPK = locobjPK;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
        hash += (locobjPK != null ? locobjPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locobj)) {
            return false;
        }
        Locobj other = (Locobj) object;
        if ((this.locobjPK == null && other.locobjPK != null) || (this.locobjPK != null && !this.locobjPK.equals(other.locobjPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Locobj[ locobjPK=" + locobjPK + " ]";
    }
    
}
