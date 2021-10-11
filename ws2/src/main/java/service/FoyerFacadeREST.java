/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import fr.emobdev.tracktri.ws2.entity.Foyer;
import fr.emobdev.tracktri.ws2.entity.FoyerPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Marie
 */
@Stateless
@Path("foyer")
public class FoyerFacadeREST extends AbstractFacade<Foyer> {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    private FoyerPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idfoyer=idfoyerValue;idutilisateur=idutilisateurValue;idadresse=idadresseValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        fr.emobdev.tracktri.ws2.entity.FoyerPK key = new fr.emobdev.tracktri.ws2.entity.FoyerPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idfoyer = map.get("idfoyer");
        if (idfoyer != null && !idfoyer.isEmpty()) {
            key.setIdfoyer(new java.lang.Integer(idfoyer.get(0)));
        }
        java.util.List<String> idutilisateur = map.get("idutilisateur");
        if (idutilisateur != null && !idutilisateur.isEmpty()) {
            key.setIdutilisateur(new java.lang.Integer(idutilisateur.get(0)));
        }
        java.util.List<String> idadresse = map.get("idadresse");
        if (idadresse != null && !idadresse.isEmpty()) {
            key.setIdadresse(new java.lang.Integer(idadresse.get(0)));
        }
        return key;
    }

    public FoyerFacadeREST() {
        super(Foyer.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Foyer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Foyer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.FoyerPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Foyer find(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.FoyerPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Foyer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Foyer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
