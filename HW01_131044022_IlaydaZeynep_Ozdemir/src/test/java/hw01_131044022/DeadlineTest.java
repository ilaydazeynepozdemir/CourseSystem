/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.Calendar;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ilayda
 */
public class DeadlineTest extends TestCase {

    public DeadlineTest() {
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
     * Test of setSign_PassDeadlines method, of class Deadline.
     */
    @Test
    public void testSetSign_PassDeadlines() {
        System.out.println("setSign_PassDeadlines");
        boolean sign = false;
        Deadline instance = new Deadline(7);
        instance.setSign_PassDeadlines(sign);
    }

    /**
     * Test of setSign_lateDeadline method, of class Deadline.
     */
    @Test
    public void testSetSign_lateDeadline() {
        System.out.println("setSign_lateDeadline");
        boolean sign = false;
        Deadline instance = new Deadline(5);
        instance.setSign_lateDeadline(sign);
    }

    /**
     * Test of getSign_PassDeadlines method, of class Deadline.
     */
    @Test
    public void testGetSign_PassDeadlines() {
        System.out.println("getSign_PassDeadlines");
        Deadline instance = new Deadline(7);
        boolean expResult = false;
        instance.setSign_PassDeadlines(expResult);
        boolean result = instance.getSign_PassDeadlines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSign_lateDeadline method, of class Deadline.
     */
    @Test
    public void testGetSign_lateDeadline() {
        System.out.println("getSign_lateDeadline");
        Deadline instance = new Deadline(8);
        boolean expResult = false;
        instance.setSign_lateDeadline(expResult);
        boolean result = instance.getSign_lateDeadline();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeadline method, of class Deadline.
     */
    @Test
    public void testSetDeadline() {
        System.out.println("setDeadline");
        int givenDay_forAssignment = 0;
        Deadline instance = new Deadline(3);
        instance.setDeadline(givenDay_forAssignment);
    }

    /**
     * Test of setLateDeadline method, of class Deadline.
     */
    @Test
    public void testSetLateDeadline() {
        System.out.println("setLateDeadline");
        int givenDay_forAssignment = 0;
        Deadline instance = new Deadline(0);
        instance.setLateDeadline(givenDay_forAssignment);
    }

    /**
     * Test of getDeadline_string method, of class Deadline.
     */
    @Test
    public void testGetDeadline_string() {
        System.out.println("getDeadline_string");
        Deadline instance = new Deadline(2);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, 2);
        String expResult = now.getTime().toString();
        String result = instance.getDeadline_string();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLateDeadline_string method, of class Deadline.
     */
    @Test
    public void testGetLateDeadline_string() {
        System.out.println("getLateDeadline_string");
        Deadline instance = new Deadline(2);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, 2 + 1);
        String expResult = now.getTime().toString();
        String result = instance.getLateDeadline_string();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Deadline.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Deadline instance = new Deadline(2);
        String expResult = ("Deadline=" + instance.getDeadline_string() + "\n" + " LateDeadline=" + instance.getLateDeadline_string());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
