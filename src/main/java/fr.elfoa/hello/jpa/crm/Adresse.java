package fr.elfoa.hello.jpa.crm;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="CP")
    private String cp;

    @Column(name="NUM")
    private Integer num;

    @Column(name="PAYS")
    private String pays;

    @Column(name="VOIE")
    private String voie;

    @Column(name="VOIETYPE")
    private String voietype;

    public Adresse() {
    }

    public Adresse(String cp, Integer num, String pays, String voie, String voietype) {
        this.cp = cp;
        this.num = num;
        this.pays = pays;
        this.voie = voie;
        this.voietype = voietype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getVoietype() {
        return voietype;
    }

    public void setVoietype(String voietype) {
        this.voietype = voietype;
    }
}
