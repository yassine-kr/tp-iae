package fr.elfoa.hello.rest.adresse;

import fr.elfoa.hello.jpa.crm.Adresse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.Logger;

@Path("adresse")
public class AdresseCRUDWS {

    private static final Logger LOG = Logger.getLogger(AdresseCRUDWS.class.getCanonicalName());

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-database");
    private EntityManager em=emf.createEntityManager();
    private EntityTransaction tx;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(em.createQuery("SELECT a FROM Adresse a").getResultList().toArray()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        return Response.ok(em.find(Adresse.class,id)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@FormParam("cp") String cp,
                           @FormParam("num") Integer num,
                           @FormParam("pays") String pays,
                           @FormParam("voie") String voie,
                           @FormParam("voietype") String voietype) {

        Adresse adresse=new Adresse(cp,num,pays,voie,voietype);
        tx = em.getTransaction();
        tx.begin();
        em.persist(adresse);
        tx.commit();

        return Response.created(URI.create("adresse/" + adresse.getId()))
                       .build();
    }



    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") Integer id) {
        Adresse adresse=em.find(Adresse.class,id);
        if(adresse!=null) {
            tx = em.getTransaction();
            tx.begin();
            em.remove(adresse);
            tx.commit();
        }
        return Response.noContent()
                       .build();
    }



    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(@PathParam("id") Integer id,
                           @FormParam("cp") String cp,
                           @FormParam("num") Integer num,
                           @FormParam("pays") String pays,
                           @FormParam("voie") String voie,
                           @FormParam("voietype") String voietype) {


        Adresse adresse=em.find(Adresse.class,id);

        tx = em.getTransaction();
        tx.begin();
        adresse.setCp(cp);
        adresse.setNum(num);
        adresse.setPays(pays);
        adresse.setVoie(voie);
        adresse.setVoietype(voietype);
        tx.commit();

        return Response.noContent()
                       .build();
    }
}