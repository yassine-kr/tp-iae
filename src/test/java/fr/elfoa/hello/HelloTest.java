package fr.elfoa.hello;

import fr.elfoa.AbstractBootstraper;
import fr.elfoa.drone.Drone;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Pierre Colomb
 */
public class HelloTest extends AbstractBootstraper {


    @BeforeClass
    public static void start(){
        init();
    }

    @Test
    public void world(){

        World world = getInstance(World.class);

        Assert.assertEquals("Hello World",world.run());
    }

    @Test
    public void you(){

        You you = getInstance(You.class);

        Assert.assertEquals("Hello You",you.run());
    }

    @Test
    public void testNotNull() throws Exception {
        startRequest();
        Drone drone=getInstance(Drone.class);
        assertNotNull(drone);
        assertNotNull(drone.getBattery());
        assertNotNull(drone.getPropellers());
        assertNotNull(drone.getConsumptionCalculator());
        assertNotNull(drone.getCurrentPosition());
        assertNotNull(drone.getPropellers().getBattery());
        assertNotNull(drone.getPropellers().getBattery());
        stopRequest();
    }

    @Test
    public void testSameBattery() throws Exception {
        startRequest();
        Drone drone=getInstance(Drone.class);
        assertEquals(drone.getBattery(),drone.getPropellers().getBattery());
        stopRequest();
    }

    @AfterClass
    public static void stop(){
        shutdown();
    }
}
