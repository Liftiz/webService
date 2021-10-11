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

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Foyer.findAll", query = "SELECT f FROM Foyer f"),
    @NamedQuery(name = "Foyer.findByIdfoyer", query = "SELECT f FROM Foyer f WHERE f.foyerPK.idfoyer = :idfoyer"),
    @NamedQuery(name = "Foyer.findByIdutilisateur", query = "SELECT f FROM Foyer f WHERE f.foyerPK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Foyer.findByIdadresse", query = "SELECT f FROM Foyer f WHERE f.foyerPK.idadresse = :idadresse"),
    @NamedQuery(name = "Foyer.findByNombre", query = "SELECT f FROM Foyer f WHERE f.nombre = :nombre")})
public class Foyer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FoyerPK foyerPK;
    private Integer nombre;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adresse adresse;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false),
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Foyer() {
    }

    public Foyer(FoyerPK foyerPK) {
        this.foyerPK = foyerPK;
    }

    public Foyer(int idfoyer, int idutilisateur, int idadresse) {
        this.foyerPK = new FoyerPK(idfoyer, idutilisateur, idadresse);
    }

    public FoyerPK getFoyerPK() {
        return foyerPK;
    }

    public void setFoyerPK(FoyerPK foyerPK) {
        this.foyerPK = foyerPK;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foyerPK != null ? foyerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foyer)) {
            return false;
        }
        Foyer other = (Foyer) object;
        if ((this.foyerPK == null && other.foyerPK != null) || (this.foyerPK != null && !this.foyerPK.equals(other.foyerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Foyer[ foyerPK=" + foyerPK + " ]";
    }
    
}
