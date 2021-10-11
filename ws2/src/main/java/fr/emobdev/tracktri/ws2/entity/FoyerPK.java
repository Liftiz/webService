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
public class FoyerPK implements Serializable {

    @Basic(optional = false)
    private int idfoyer;
    @Basic(optional = false)
    @NotNull
    private int idutilisateur;
    @Basic(optional = false)
    @NotNull
    private int idadresse;

    public FoyerPK() {
    }

    public FoyerPK(int idfoyer, int idutilisateur, int idadresse) {
        this.idfoyer = idfoyer;
        this.idutilisateur = idutilisateur;
        this.idadresse = idadresse;
    }

    public int getIdfoyer() {
        return idfoyer;
    }

    public void setIdfoyer(int idfoyer) {
        this.idfoyer = idfoyer;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
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
        hash += (int) idfoyer;
        hash += (int) idutilisateur;
        hash += (int) idadresse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoyerPK)) {
            return false;
        }
        FoyerPK other = (FoyerPK) object;
        if (this.idfoyer != other.idfoyer) {
            return false;
        }
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idadresse != other.idadresse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.FoyerPK[ idfoyer=" + idfoyer + ", idutilisateur=" + idutilisateur + ", idadresse=" + idadresse + " ]";
    }
    
}
