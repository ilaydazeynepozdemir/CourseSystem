/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ilayda
 */
public class WhiteBoardDescriptionTest extends TestCase{
    
    public WhiteBoardDescriptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDescription method, of class WhiteBoardDescription.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String givenDescription = "";
        WhiteBoardDescription instance = new WhiteBoardDescription();
        instance.setDescription(givenDescription);
    }

    /**
     * Test of getDescription method, of class WhiteBoardDescription.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        WhiteBoardDescription instance = new WhiteBoardDescription();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class WhiteBoardDescription.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "ek kisim";
        WhiteBoardDescription instance = new WhiteBoardDescription(expResult, "ek kisim");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
