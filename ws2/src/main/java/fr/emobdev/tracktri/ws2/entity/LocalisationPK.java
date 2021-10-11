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
import javax.validation.constraints.Size;

/**
 *
 * @author Marie
 */
@Embeddable
public class LocalisationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String laltitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String longitude;
    @Basic(optional = false)
    @NotNull
    private int idadresse;

    public LocalisationPK() {
    }

    public LocalisationPK(String laltitude, String longitude, int idadresse) {
        this.laltitude = laltitude;
        this.longitude = longitude;
        this.idadresse = idadresse;
    }

    public String getLaltitude() {
        return laltitude;
    }

    public void setLaltitude(String laltitude) {
        this.laltitude = laltitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
        hash += (laltitude != null ? laltitude.hashCode() : 0);
        hash += (longitude != null ? longitude.hashCode() : 0);
        hash += (int) idadresse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalisationPK)) {
            return false;
        }
        LocalisationPK other = (LocalisationPK) object;
        if ((this.laltitude == null && other.laltitude != null) || (this.laltitude != null && !this.laltitude.equals(other.laltitude))) {
            return false;
        }
        if ((this.longitude == null && other.longitude != null) || (this.longitude != null && !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.idadresse != other.idadresse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.LocalisationPK[ laltitude=" + laltitude + ", longitude=" + longitude + ", idadresse=" + idadresse + " ]";
    }
    
}
