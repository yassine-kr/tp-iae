package fr.elfoa.drone;

import javax.enterprise.context.RequestScoped;

public interface IBattery {

    void use(Integer power);
    Integer getPower();

}
