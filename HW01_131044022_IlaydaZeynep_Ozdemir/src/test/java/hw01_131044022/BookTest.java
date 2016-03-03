/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

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
public class BookTest {
    
    public BookTest() {
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
     * Test of setNumOfPage method, of class Book.
     */
    @Test
    public void testSetNumOfPage() {
        System.out.println("setNumOfPage");
        int page = 100;
        Book instance = new Book("adi", page);
        instance.setNumOfPage(page);
    }

    /**
     * Test of getNumOfPage method, of class Book.
     */
    @Test
    public void testGetNumOfPage() {
        System.out.println("getNumOfPage");
        Book instance = new Book("adi",50);
        int expResult = 50;
        int result = instance.getNumOfPage();
        assertEquals(expResult, result);
    }
    
}
