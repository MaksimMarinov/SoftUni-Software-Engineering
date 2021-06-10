package blueOrigin;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private static final int capacity = 100;
    private static final String name = "Vostok1";
    private static final Astronaut astronaut1 = new Astronaut("Gagarin",50 );
    private static final Astronaut astronaut2 = new Astronaut("Ivanov",99 );
    private Spaceship spaceship;

    @Before
    public void setUp(){
     spaceship= new Spaceship(name, capacity);
        spaceship.add(astronaut1);
    }
    @Test
    public void testCorrectConstructor(){
        assertEquals(name, spaceship.getName());
        assertEquals(capacity, spaceship.getCapacity());

    }
    @Test
    public void testGetCount(){
        spaceship.add(astronaut2);
        assertEquals(2, spaceship.getCount());
    }
    @Test(expected =  IllegalArgumentException.class)
    public void testAddWithExistingAstronaut(){
        spaceship.add(astronaut1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithMoreThanCapacity(){
       Spaceship spaceship2= new Spaceship("Some", 1);
        spaceship2.add(astronaut1);
        spaceship2.add(astronaut2);

    }
    @Test
    public void testRemoveExisting(){

    assertTrue(spaceship.remove("Gagarin"));
    }

    @Test
    public void testRemoveNonExisting(){
        assertFalse(spaceship.remove("Ivanov"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityUnderZero(){
        new Spaceship("Invalid", -1);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameWithNullExcExpected(){
        new Spaceship(null, 1);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameWithEmptyExcExpected(){
        new Spaceship(" ", 1);
    }

}
