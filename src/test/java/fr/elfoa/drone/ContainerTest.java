package fr.elfoa.drone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pierre Colomb
 */
public class ContainerTest {

    @Test
    public void getWeight() throws Exception {
        Container container=new Container();

        container.load(new Item());

        assertEquals(0,container.getWeight().intValue());
    }

}