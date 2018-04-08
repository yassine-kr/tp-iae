package fr.elfoa.hello.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pierre Colomb
 */
@Entity
public class A {

    @Id
    @GeneratedValue
    private Integer id;

    private String a_1;

    private String a_2;

    @OneToMany(cascade = CascadeType.ALL)
    private List<C> cs;

    public A(){}



    public A(String a_1, String a_2) {
        this.a_1 = a_1;
        this.a_2 = a_2;
        cs=new ArrayList<>();
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getA_1() {
        return a_1;
    }



    public void setA_1(String a_1) {
        this.a_1 = a_1;
    }



    public String getA_2() {
        return a_2;
    }



    public void setA_2(String a_2) {
        this.a_2 = a_2;
    }

    public List<C> getCs(){
        return cs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof A))
            return false;
        A a = (A) o;
        return Objects.equals(id, a.id) &&
               Objects.equals(a_1, a.a_1) &&
               Objects.equals(a_2, a.a_2);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, a_1, a_2);
    }
}
