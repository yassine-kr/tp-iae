package fr.elfoa.drone;

import static org.junit.Assert.assertEquals;

import fr.elfoa.AbstractBootstraper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Pierre Colomb
 */
public class DroneTest extends AbstractBootstraper {

    @BeforeClass
    public static void start(){
        init();
    }

    @AfterClass
    public static void stop(){
        shutdown();
    }

    private static final Point ORIGIN = new Point(0d,0d,0d);

    @Test
    public void tackOff() throws Exception {

        startRequest();
        Drone drone = getInstance(Drone.class);

        drone.tackOff();

        assertEquals(50d,drone.getCurrentPosition().getAltitude(),0);
        stopRequest();

    }



    @Test
    public void flyTo() throws Exception {
        startRequest();
        Drone drone = getInstance(Drone.class);

        drone.tackOff();

        Point destination=new Point(50.0,50.0,50.0);
        drone.flyTo(destination);

        assertEquals(50.0,drone.getCurrentPosition().getLatitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getAltitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getLongitude(),0.0);
        stopRequest();

    }



    @Test
    public void landing() throws Exception {

        startRequest();
        Drone drone = getInstance(Drone.class);

        drone.tackOff();

        drone.flyTo(new Point(50.0,50.0,50.0));

        drone.landing();

        assertEquals(0d,drone.getCurrentPosition().getAltitude(),0.0);
        stopRequest();
    }



    @Test
    public void isCanFly() throws Exception {
        startRequest();
        Drone drone = getInstance(Drone.class);

        assertEquals(true,drone.isCanFly());
        stopRequest();
    }



    @Test
    public void getCurrentPosition() throws Exception {
        startRequest();
        Drone drone = getInstance(Drone.class);

        drone.tackOff();

        Point destination=new Point(50.0,50.0,50.0);
        drone.flyTo(destination);

        assertEquals(50.0,drone.getCurrentPosition().getLatitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getAltitude(),0.0);
        assertEquals(50.0,drone.getCurrentPosition().getLongitude(),0.0);
        stopRequest();
    }

}