package fr.elfoa.drone;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Pierre Colomb
 */
public class DroneTest {

    private static final Point ORIGIN = new Point(0d,0d,0d);

    @Test
    public void tackOff() throws Exception {

        Drone drone = new Drone(ORIGIN);

        drone.tackOff();

        assertEquals(50d,drone.getCurrentPosition().getAltitude(),0);

    }



    @Test
    public void flyTo() throws Exception {
        Drone drone = new Drone(ORIGIN);

        drone.tackOff();

        Point destination=new Point(50.0,50.0,50.0);
        drone.flyTo(destination);

        assertEquals(50.0,drone.getCurrentPosition().getLatitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getAltitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getLongitude(),0.0);

    }



    @Test
    public void landing() throws Exception {
        Drone drone = new Drone(ORIGIN);

        drone.tackOff();

        drone.flyTo(new Point(50.0,50.0,50.0));

        drone.landing();

        assertEquals(0d,drone.getCurrentPosition().getAltitude(),0.0);

    }



    @Test
    public void isCanFly() throws Exception {
        Drone drone = new Drone(ORIGIN);

        assertEquals(true,drone.isCanFly());
    }



    @Test
    public void getCurrentPosition() throws Exception {
        Drone drone = new Drone(ORIGIN);

        drone.tackOff();

        Point destination=new Point(50.0,50.0,50.0);
        drone.flyTo(destination);

        assertEquals(50.0,drone.getCurrentPosition().getLatitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getAltitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getLongitude(),0.0);
    }

}