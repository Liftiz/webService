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
public class ImgPK implements Serializable {

    @Basic(optional = false)
    private int idimg;
    @Basic(optional = false)
    @NotNull
    private int idobjet;

    public ImgPK() {
    }

    public ImgPK(int idimg, int idobjet) {
        this.idimg = idimg;
        this.idobjet = idobjet;
    }

    public int getIdimg() {
        return idimg;
    }

    public void setIdimg(int idimg) {
        this.idimg = idimg;
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
        hash += (int) idimg;
        hash += (int) idobjet;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImgPK)) {
            return false;
        }
        ImgPK other = (ImgPK) object;
        if (this.idimg != other.idimg) {
            return false;
        }
        if (this.idobjet != other.idobjet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.ImgPK[ idimg=" + idimg + ", idobjet=" + idobjet + " ]";
    }
    
}
