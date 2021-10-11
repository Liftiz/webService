/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import fr.emobdev.tracktri.ws2.entity.Localisation;
import fr.emobdev.tracktri.ws2.entity.LocalisationPK;
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
@Path("localisation")
public class LocalisationFacadeREST extends AbstractFacade<Localisation> {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    private LocalisationPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;laltitude=laltitudeValue;longitude=longitudeValue;idadresse=idadresseValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        fr.emobdev.tracktri.ws2.entity.LocalisationPK key = new fr.emobdev.tracktri.ws2.entity.LocalisationPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> laltitude = map.get("laltitude");
        if (laltitude != null && !laltitude.isEmpty()) {
            key.setLaltitude(laltitude.get(0));
        }
        java.util.List<String> longitude = map.get("longitude");
        if (longitude != null && !longitude.isEmpty()) {
            key.setLongitude(longitude.get(0));
        }
        java.util.List<String> idadresse = map.get("idadresse");
        if (idadresse != null && !idadresse.isEmpty()) {
            key.setIdadresse(new java.lang.Integer(idadresse.get(0)));
        }
        return key;
    }

    public LocalisationFacadeREST() {
        super(Localisation.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Localisation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Localisation entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.LocalisationPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Localisation find(@PathParam("id") PathSegment id) {
        fr.emobdev.tracktri.ws2.entity.LocalisationPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Localisation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Localisation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
