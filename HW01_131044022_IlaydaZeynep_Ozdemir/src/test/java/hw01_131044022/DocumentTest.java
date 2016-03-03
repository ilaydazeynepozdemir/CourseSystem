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
public class DocumentTest {
    
    public DocumentTest() {
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
     * Test of setNameOfDocument method, of class Document.
     */
    @Test
    public void testSetNameOfDocument() {
        System.out.println("setNameOfDocument");
        String name = "";
        Document instance = new File();
        instance.setNameOfDocument(name);
    }

    /**
     * Test of getNameOfDocument method, of class Document.
     */
    @Test
    public void testGetNameOfDocument() {
        System.out.println("getNameOfDocument");
        String expResult = "adi";
        Document instance = new File(expResult);
        String result = instance.getNameOfDocument();
        assertEquals(expResult, result);
    }
    
}
