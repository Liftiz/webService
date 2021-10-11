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
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdadresse", query = "SELECT a FROM Adresse a WHERE a.idadresse = :idadresse"),
    @NamedQuery(name = "Adresse.findByLigne1", query = "SELECT a FROM Adresse a WHERE a.ligne1 = :ligne1"),
    @NamedQuery(name = "Adresse.findByLigne2", query = "SELECT a FROM Adresse a WHERE a.ligne2 = :ligne2"),
    @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville"),
    @NamedQuery(name = "Adresse.findByCp", query = "SELECT a FROM Adresse a WHERE a.cp = :cp")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idadresse;
    @Size(max = 255)
    private String ligne1;
    @Size(max = 255)
    private String ligne2;
    @Size(max = 45)
    private String ville;
    @Size(max = 45)
    private String cp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
    private Collection<Locobj> locobjCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
    private Collection<Localisation> localisationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
    private Collection<Foyer> foyerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
    private Collection<Histoloc> histolocCollection;

    public Adresse() {
    }

    public Adresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public Integer getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Collection<Locobj> getLocobjCollection() {
        return locobjCollection;
    }

    public void setLocobjCollection(Collection<Locobj> locobjCollection) {
        this.locobjCollection = locobjCollection;
    }

    public Collection<Localisation> getLocalisationCollection() {
        return localisationCollection;
    }

    public void setLocalisationCollection(Collection<Localisation> localisationCollection) {
        this.localisationCollection = localisationCollection;
    }

    public Collection<Foyer> getFoyerCollection() {
        return foyerCollection;
    }

    public void setFoyerCollection(Collection<Foyer> foyerCollection) {
        this.foyerCollection = foyerCollection;
    }

    public Collection<Histoloc> getHistolocCollection() {
        return histolocCollection;
    }

    public void setHistolocCollection(Collection<Histoloc> histolocCollection) {
        this.histolocCollection = histolocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadresse != null ? idadresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idadresse == null && other.idadresse != null) || (this.idadresse != null && !this.idadresse.equals(other.idadresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Adresse[ idadresse=" + idadresse + " ]";
    }
    
}
