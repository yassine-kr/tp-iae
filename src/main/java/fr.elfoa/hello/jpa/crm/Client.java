package fr.elfoa.hello.jpa.crm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CLIENT")
@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="MAIL")
    private String mail;

    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    @Column(name="TELEPHONE")
    private String telephone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="CLIENT_ADRESSE",
            joinColumns=@JoinColumn(name="Client_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="adresses_ID", referencedColumnName="ID"))
    private List<Adresse> adresses;

    public Client() {
    }

    public Client(String mail, String nom, String prenom, String telephone) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresses=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
}
