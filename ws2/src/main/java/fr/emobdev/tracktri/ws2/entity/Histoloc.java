/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Histoloc.findAll", query = "SELECT h FROM Histoloc h"),
    @NamedQuery(name = "Histoloc.findByIdloc", query = "SELECT h FROM Histoloc h WHERE h.histolocPK.idloc = :idloc"),
    @NamedQuery(name = "Histoloc.findByDatetime", query = "SELECT h FROM Histoloc h WHERE h.datetime = :datetime"),
    @NamedQuery(name = "Histoloc.findByIdadresse", query = "SELECT h FROM Histoloc h WHERE h.histolocPK.idadresse = :idadresse"),
    @NamedQuery(name = "Histoloc.findByIdobjet", query = "SELECT h FROM Histoloc h WHERE h.histolocPK.idobjet = :idobjet")})
public class Histoloc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistolocPK histolocPK;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adresse adresse;
    @JoinColumns({
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false),
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Objet objet;

    public Histoloc() {
    }

    public Histoloc(HistolocPK histolocPK) {
        this.histolocPK = histolocPK;
    }

    public Histoloc(int idloc, int idadresse, int idobjet) {
        this.histolocPK = new HistolocPK(idloc, idadresse, idobjet);
    }

    public HistolocPK getHistolocPK() {
        return histolocPK;
    }

    public void setHistolocPK(HistolocPK histolocPK) {
        this.histolocPK = histolocPK;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
        hash += (histolocPK != null ? histolocPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Histoloc)) {
            return false;
        }
        Histoloc other = (Histoloc) object;
        if ((this.histolocPK == null && other.histolocPK != null) || (this.histolocPK != null && !this.histolocPK.equals(other.histolocPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Histoloc[ histolocPK=" + histolocPK + " ]";
    }
    
}
