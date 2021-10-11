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
public class OpinionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int idobj;
    @Basic(optional = false)
    @NotNull
    private int idutilisateur;

    public OpinionPK() {
    }

    public OpinionPK(int idobj, int idutilisateur) {
        this.idobj = idobj;
        this.idutilisateur = idutilisateur;
    }

    public int getIdobj() {
        return idobj;
    }

    public void setIdobj(int idobj) {
        this.idobj = idobj;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idobj;
        hash += (int) idutilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpinionPK)) {
            return false;
        }
        OpinionPK other = (OpinionPK) object;
        if (this.idobj != other.idobj) {
            return false;
        }
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.OpinionPK[ idobj=" + idobj + ", idutilisateur=" + idutilisateur + " ]";
    }
    
}
