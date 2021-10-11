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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Img.findAll", query = "SELECT i FROM Img i"),
    @NamedQuery(name = "Img.findByIdimg", query = "SELECT i FROM Img i WHERE i.imgPK.idimg = :idimg"),
    @NamedQuery(name = "Img.findByUrl", query = "SELECT i FROM Img i WHERE i.url = :url"),
    @NamedQuery(name = "Img.findByIdobjet", query = "SELECT i FROM Img i WHERE i.imgPK.idobjet = :idobjet")})
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImgPK imgPK;
    @Size(max = 255)
    private String url;
    @JoinColumns({
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false),
        @JoinColumn(name = "idobjet", referencedColumnName = "idobjet", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Objet objet;

    public Img() {
    }

    public Img(ImgPK imgPK) {
        this.imgPK = imgPK;
    }

    public Img(int idimg, int idobjet) {
        this.imgPK = new ImgPK(idimg, idobjet);
    }

    public ImgPK getImgPK() {
        return imgPK;
    }

    public void setImgPK(ImgPK imgPK) {
        this.imgPK = imgPK;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        hash += (imgPK != null ? imgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Img)) {
            return false;
        }
        Img other = (Img) object;
        if ((this.imgPK == null && other.imgPK != null) || (this.imgPK != null && !this.imgPK.equals(other.imgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Img[ imgPK=" + imgPK + " ]";
    }
    
}
