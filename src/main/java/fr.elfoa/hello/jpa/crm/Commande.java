package fr.elfoa.hello.jpa.crm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "COMMANDE")
@Entity
public class Commande {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="DATE")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADRESSE_ID")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="COMMANDE_ITEM",
            joinColumns=@JoinColumn(name="Commande_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="items_ID", referencedColumnName="ID"))
    private List<Item> items;

    public Commande() {
    }

    public Commande(Date date, Adresse adresse, Client client) {
        this.date = date;
        this.adresse = adresse;
        this.client = client;
        items=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

