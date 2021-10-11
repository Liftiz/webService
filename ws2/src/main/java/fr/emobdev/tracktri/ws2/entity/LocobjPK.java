/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marie
 */
@Embeddable
public class LocobjPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int idobjet;
    @Basic(optional = false)
    @NotNull
    private int idadresse;

    public LocobjPK() {
    }

    public LocobjPK(int idobjet, int idadresse) {
        this.idobjet = idobjet;
        this.idadresse = idadresse;
    }

    public int getIdobjet() {
        return idobjet;
    }

    public void setIdobjet(int idobjet) {
        this.idobjet = idobjet;
    }

    public int getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(int idadresse) {
        this.idadresse = idadresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idobjet;
        hash += (int) idadresse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocobjPK)) {
            return false;
        }
        LocobjPK other = (LocobjPK) object;
        if (this.idobjet != other.idobjet) {
            return false;
        }
        if (this.idadresse != other.idadresse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.LocobjPK[ idobjet=" + idobjet + ", idadresse=" + idadresse + " ]";
    }
    
}
