/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.emobdev.tracktri.ws2.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Marie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Opinion.findAll", query = "SELECT o FROM Opinion o"),
    @NamedQuery(name = "Opinion.findByIdobj", query = "SELECT o FROM Opinion o WHERE o.opinionPK.idobj = :idobj"),
    @NamedQuery(name = "Opinion.findByIdutilisateur", query = "SELECT o FROM Opinion o WHERE o.opinionPK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Opinion.findByVote", query = "SELECT o FROM Opinion o WHERE o.vote = :vote")})
public class Opinion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpinionPK opinionPK;
    private Integer vote;

    public Opinion() {
    }

    public Opinion(OpinionPK opinionPK) {
        this.opinionPK = opinionPK;
    }

    public Opinion(int idobj, int idutilisateur) {
        this.opinionPK = new OpinionPK(idobj, idutilisateur);
    }

    public OpinionPK getOpinionPK() {
        return opinionPK;
    }

    public void setOpinionPK(OpinionPK opinionPK) {
        this.opinionPK = opinionPK;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opinionPK != null ? opinionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opinion)) {
            return false;
        }
        Opinion other = (Opinion) object;
        if ((this.opinionPK == null && other.opinionPK != null) || (this.opinionPK != null && !this.opinionPK.equals(other.opinionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.emobdev.tracktri.ws2.entity.Opinion[ opinionPK=" + opinionPK + " ]";
    }
    
}
