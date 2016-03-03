/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;
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
public class UserTest extends TestCase {

    public UserTest() {
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
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new Student("");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWishOfUser method, of class User.
     */
    @Test
    public void testSetWishOfUser() {
        System.out.println("setWishOfUser");
        boolean wish = false;
        User instance = new Teacher();
        instance.setWishOfUser(wish);
    }

    /**
     * Test of getWishOfUser method, of class User.
     */
    @Test
    public void testGetWishOfUser() {
        System.out.println("getWishOfUser");
        User instance = new Student();
        boolean expResult = false;
        instance.setWishOfUser(expResult);
        boolean result = instance.getWishOfUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String TakenUsername = "";
        User instance = new Student();
        instance.setUsername(TakenUsername);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object givenUser = new Teacher();
        User instance = new Teacher();
        boolean expResult = true;
        boolean result = instance.equals(givenUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new Teacher("deneme");
        String expResult = "deneme";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of existed method, of class User.
     */
    @Test
    public void testExisted() {
        System.out.println("existed");
        User instance = new Student();
        boolean expResult = false;
        ArrayList<User> array = new ArrayList<>();

        boolean result = instance.existed(instance,array);
        assertEquals(expResult, result);
    }

    /**
     * Test of FillCoursesOfUser method, of class User.
     */
    @Test
    public void testFillCoursesOfUser() {
        System.out.println("FillCoursesOfUser");
        Course courseOfUser = new Course();
        User instance = new Student();
        instance.FillCoursesOfUser(courseOfUser);
    }

    /**
     * Test of listOfCourses method, of class User.
     */
    @Test
    public void testListOfCourses() {
        System.out.println("listOfCourses");
        User instance = new Student();
        instance.listOfCourses();
    }

    /**
     * Test of RequestToExit method, of class User.
     */
    @Test
    public void testRequestToExit() {
        System.out.println("RequestToExit");
        Object fromHere = new CourseSystem();
        User instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.RequestToExit(fromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerSystem method, of class User.
     */
    @Test
    public void testRegisterSystem() {
        System.out.println("registerSystem");
        CourseSystem toRegister = new CourseSystem();
        User instance = new Student();
        boolean expResult = false;
        boolean result = instance.registerSystem(toRegister);
        assertEquals(expResult, result);
    }

   

}
