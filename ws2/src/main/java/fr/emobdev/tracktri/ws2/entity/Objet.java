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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Objet.findAll", query = "SELECT o FROM Objet o"),
    @NamedQuery(name = "Objet.findByIdobjet", query = "SELECT o FROM Objet o WHERE o.idobjet = :idobjet"),
    @NamedQuery(name = "Objet.findByDesc", query = "SELECT o FROM Objet o WHERE o.desc = :desc"),
    @NamedQuery(name = "Objet.findByOpinion", query = "SELECT o FROM Objet o WHERE o.opinion = :opinion")})
public class Objet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idobjet;
    @Size(max = 255)
    private String desc;
    @Basic(optional = false)
    @NotNull
    private float opinion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private Collection<Horaire> horaireCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objet")
    private Locobj locobj;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objet")
    private Img img;
    @JoinColumns({
        @JoinColumn(name = "idtypeobj", referencedColumnName = "idtypeobj"),
        @JoinColumn(name = "idtypeobj", referencedColumnName = "idtypeobj")})
    @ManyToOne(optional = false)
    private Typeobj typeobj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private Collection<Histoloc> histolocCollection;

    public Objet() {
    }

    public Objet(Integer idobjet) {
        this.idobjet = idobjet;
    }

    public Objet(Integer idobjet, float opinion) {
        this.idobjet = idobjet;
        this.opinion = opinion;
    }

    public Integer getIdobjet() {
        return idobjet;
    }

    public void setIdobjet(Integer idobjet) {
        this.idobjet = idobjet;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getOpinion() {
        return opinion;
    }

    public void setOpinion(float opinion) {
        this.opinion = opinion;
    }

    public Collection<Horaire> getHoraireCollection() {
        return horaireCollection;
    }

    public void setHoraireCollection(Collection<Horaire> horaireCollection) {
        this.horaireCollection = horaireCollection;
    }

    public Locobj getLocobj() {
        return locobj;
    }

    public void setLocobj(Locobj locobj) {
        this.locobj = locobj;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public Typeobj getTypeobj() {
        return typeobj;
    }

    public void setTypeobj(Typeobj typeobj) {
        this.typeobj = typeobj;
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
        hash += (idobjet != null ? idobjet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objet)) {
            return false;
        }
        Objet other = (Objet) object;
        if ((this.idobjet == null && other.idobjet != null) || (this.idobjet != null && !this.idobjet.equals(other.idobjet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Objet[ idobjet=" + idobjet + " ]";
    }
    
}
