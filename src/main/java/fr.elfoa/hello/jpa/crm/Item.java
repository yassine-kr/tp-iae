package fr.elfoa.hello.jpa.crm;

import javax.persistence.*;

@Table(name = "ITEM")
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="LABEL")
    private String label;

    @Column(name="SIZE")
    private Integer size;

    @Column(name="WEIGHT")
    private Integer weight;

    public Item() {
    }

    public Item(String label, Integer size, Integer weight) {
        this.label = label;
        this.size = size;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
