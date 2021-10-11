/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import fr.emobdev.tracktri.ws2.entity.Histoloc;
import fr.emobdev.tracktri.ws2.entity.HistolocPK;
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
@Path("histoloc")
public class HistolocFacadeREST extends AbstractFacade<Histoloc> {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    private HistolocPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idloc=idlocValue;idadresse=idadresseValue;idobjet=idobjetValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        fr.emobdev.tracktri.ws2.entity.HistolocPK key = new fr.emobdev.tracktri.ws2.entity.HistolocPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idloc = map.get("idloc");
        if (idloc != null && !idloc.isEmpty()) {
            key.setIdloc(new java.lang.Integer(idloc.get(0)));
        }
        java.util.List<String> idadresse = map.get("idadresse");
        if (idadresse != null && !idadresse.isEmpty()) {
            key.setIdadresse(new java.lang.Integer(idadresse.get(0)));
        }
        java.util.List<String> idobjet = map.get("idobjet");
        if (idobjet != null && !idobjet.isEmpty()) {
            key.setIdobjet(new java.lang.Integer(idobjet.get(0)));
        }
        return key;
    }

    public HistolocFacadeREST() {
        super(Histoloc.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Histoloc entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Histoloc entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.HistolocPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Histoloc find(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.HistolocPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Histoloc> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Histoloc> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
