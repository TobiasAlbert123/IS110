

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HouseTest
{
    private House h;
    /**
     * Default constructor for test class HouseTest
     */
    public HouseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        h = new House(0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testSetAmountOfrooms() {
        assertEquals(true, h.setAmountOfRooms(5));
        assertEquals(5, h.getAmountOfRooms());
    }
    
    @Test
    public void testMakeNewRoom() {
        assertEquals(true, h.makeNewRoom("bedroom", "1"));
        assertEquals(1, h.getAmountOfRooms());
    }
    
    @Test
    public void testMakeSpecific() {
        assertEquals(true, h.makeSpecific("bedroom"));
    }
    
    @Test
    public void testNegativeRooms() {
        assertEquals(false, h.setAmountOfRooms(-1));
    }
    
    @Test
    public void testPrintRoom() {
        assertEquals(true, h.printRoom("all"));
    }

    @Test
    public void testGetAmountOfRooms()
    {
        assertEquals(0, h.getAmountOfRooms());
    }
}

