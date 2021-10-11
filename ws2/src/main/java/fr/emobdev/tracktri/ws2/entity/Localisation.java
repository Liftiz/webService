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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Localisation.findAll", query = "SELECT l FROM Localisation l"),
    @NamedQuery(name = "Localisation.findByLaltitude", query = "SELECT l FROM Localisation l WHERE l.localisationPK.laltitude = :laltitude"),
    @NamedQuery(name = "Localisation.findByLongitude", query = "SELECT l FROM Localisation l WHERE l.localisationPK.longitude = :longitude"),
    @NamedQuery(name = "Localisation.findByIdadresse", query = "SELECT l FROM Localisation l WHERE l.localisationPK.idadresse = :idadresse")})
public class Localisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalisationPK localisationPK;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adresse adresse;

    public Localisation() {
    }

    public Localisation(LocalisationPK localisationPK) {
        this.localisationPK = localisationPK;
    }

    public Localisation(String laltitude, String longitude, int idadresse) {
        this.localisationPK = new LocalisationPK(laltitude, longitude, idadresse);
    }

    public LocalisationPK getLocalisationPK() {
        return localisationPK;
    }

    public void setLocalisationPK(LocalisationPK localisationPK) {
        this.localisationPK = localisationPK;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localisationPK != null ? localisationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localisation)) {
            return false;
        }
        Localisation other = (Localisation) object;
        if ((this.localisationPK == null && other.localisationPK != null) || (this.localisationPK != null && !this.localisationPK.equals(other.localisationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Localisation[ localisationPK=" + localisationPK + " ]";
    }
    
}
