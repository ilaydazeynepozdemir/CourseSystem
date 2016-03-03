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
public class MyExceptionTest {

    public MyExceptionTest() {
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
     * Test of getNameOfException method, of class MyException.
     */
    @Test
    public void testGetNameOfException() {
        System.out.println("getNameOfException");

        String expResult = "deneme";
        MyException instance = new MyException(expResult);
        String result = instance.getNameOfException();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MyException.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object thisException = new MyException("deneme");
        MyException instance = new MyException("deneme");
        boolean expResult = true;
        boolean result = instance.equals(thisException);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MyException.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MyException instance = new MyException("");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
