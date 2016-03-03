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
public class AuthorizedTest {

    public AuthorizedTest() {
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
     * Test of addUser method, of class Authorized.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User added = new Student();
        Object addedFromHere = new CourseSystem();
        Authorized instance = new Administrator();
        instance.addUser(added, addedFromHere);
        boolean expResult = false;
        boolean result = instance.addUser(added, addedFromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveUser method, of class Authorized.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("RemoveUser");
        User deleted = new Teacher();
        Object deletedFromHere = new CourseSystem();
        Authorized instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.RemoveUser(deleted, deletedFromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of controlled method, of class Authorized.
     */
    @Test
    public void testControlled() {
        System.out.println("controlled");
        Authorized instance = new Administrator();
        Object controlThis = new CourseSystem((Administrator) instance);
        instance.controlled(controlThis);
    }

    /**
     * Test of listOfUser method, of class Authorized.
     */
    @Test
    public void testListOfUser() {
        System.out.println("listOfUser");
        Object InThis = new Course();
        Authorized instance = new Teacher();
        instance.listOfUser(InThis);
    }

    

}
