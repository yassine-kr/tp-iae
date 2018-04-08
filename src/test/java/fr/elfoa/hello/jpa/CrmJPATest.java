package fr.elfoa.hello.jpa;



import fr.elfoa.hello.jpa.crm.Adresse;
import fr.elfoa.hello.jpa.crm.Client;
import fr.elfoa.hello.jpa.crm.Commande;
import fr.elfoa.hello.jpa.crm.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;


/**
 * @author Pierre Colomb
 */
public class CrmJPATest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-database");
    private EntityManager em;
    private EntityTransaction tx;


    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }


    @After
    public void closeEntityManager() throws Exception {
       if (em != null) {
           em.close();
       }
    }

    @Test
    public void test(){
        Client client=new Client("mail","nom","prenom","tel");
        Adresse adresseClient=new Adresse("cp",12,"pays","voie","type");
        client.getAdresses().add(adresseClient);
        Item item=new Item("label",15,45);
        Adresse adresseCommande=new Adresse("cp",12,"pays","voie","type");
        Commande commande=new Commande(new Date(),adresseCommande,client);
        commande.getItems().add(item);

        tx.begin();
        em.persist(client);
        em.persist(commande);
        tx.commit();

        Assert.assertEquals(1,client.getId().intValue());
        Assert.assertEquals(2,adresseClient.getId().intValue());
        Assert.assertEquals(3,commande.getId().intValue());
        Assert.assertEquals(4,adresseCommande.getId().intValue());
        Assert.assertEquals(5,item.getId().intValue());
    }

}