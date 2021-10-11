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
public class HistolocPK implements Serializable {

    @Basic(optional = false)
    private int idloc;
    @Basic(optional = false)
    @NotNull
    private int idadresse;
    @Basic(optional = false)
    @NotNull
    private int idobjet;

    public HistolocPK() {
    }

    public HistolocPK(int idloc, int idadresse, int idobjet) {
        this.idloc = idloc;
        this.idadresse = idadresse;
        this.idobjet = idobjet;
    }

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    public int getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(int idadresse) {
        this.idadresse = idadresse;
    }

    public int getIdobjet() {
        return idobjet;
    }

    public void setIdobjet(int idobjet) {
        this.idobjet = idobjet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idloc;
        hash += (int) idadresse;
        hash += (int) idobjet;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistolocPK)) {
            return false;
        }
        HistolocPK other = (HistolocPK) object;
        if (this.idloc != other.idloc) {
            return false;
        }
        if (this.idadresse != other.idadresse) {
            return false;
        }
        if (this.idobjet != other.idobjet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.HistolocPK[ idloc=" + idloc + ", idadresse=" + idadresse + ", idobjet=" + idobjet + " ]";
    }
    
}
