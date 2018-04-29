package fr.elfoa.hello.rest.adresse;

import fr.elfoa.hello.jpa.crm.Adresse;
import fr.elfoa.hello.rest.todo.Todo;
import fr.elfoa.hello.rest.todo.TodoListWS;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class AdresseCRUDWSTest extends JerseyTest{

    static private int id=0;

    @Override
    protected Application configure() {
        return new ResourceConfig(AdresseCRUDWS.class);
    }


    @Before
    public void before(){

        target("adresse").request().post(Entity.form(new Form().param("cp","c")
                .param("num","5").param("pays","p").param("voie","v").param("voietype","vo")));
        id++;
    }

    @Test
    public void post_get2() throws Exception {


        Adresse adresse = target("adresse/"+id).request().get(Adresse.class);

        Assert.assertEquals("c",adresse.getCp());
        Assert.assertEquals(new Integer(5),adresse.getNum());
        Assert.assertEquals("p",adresse.getPays());
        Assert.assertEquals("v",adresse.getVoie());
        Assert.assertEquals("vo",adresse.getVoietype());

    }

    @Test
    public void put() throws Exception {


        Response response = target("adresse/"+id).request().put(Entity.form(new Form().param("cp","ca")
                .param("num","10").param("pays","pa").param("voie","va").param("voietype","voa")));

        assertEquals(204, response.getStatus());

        Adresse adresse = target("adresse/"+id).request().get(Adresse.class);

        Assert.assertEquals("ca",adresse.getCp());
        Assert.assertEquals(new Integer(10),adresse.getNum());
        Assert.assertEquals("pa",adresse.getPays());
        Assert.assertEquals("va",adresse.getVoie());
        Assert.assertEquals("voa",adresse.getVoietype());

    }

    @Test
    public void delete_get() throws Exception {


        Response response = target("adresse/"+id).request().delete();

        assertEquals(204, response.getStatus());

        Adresse[] adresses = target("adresse").request().get(Adresse[].class);

        Assert.assertTrue(!Arrays.stream(adresses).mapToInt(Adresse::getId).filter((i)->i==id).findFirst().isPresent());

    }



}
