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
public class AdministratorTest {
    
    public AdministratorTest() {
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
     * Test of setSystem method, of class Administrator.
     */
    @Test
    public void testSetSystem() {
        System.out.println("setSystem");
        CourseSystem InstallSystem = null;
        Administrator instance = new Administrator();
        instance.setSystem(InstallSystem);
    }

    /**
     * Test of InstallSystem method, of class Administrator.
     */
    @Test
    public void testInstallSystem() {
        System.out.println("InstallSystem");
        CourseSystem Install = new CourseSystem();
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.InstallSystem(Install);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerSystem method, of class Administrator.
     */
    @Test
    public void testRegisterSystem() {
        System.out.println("registerSystem");
        CourseSystem toRegister =  new CourseSystem();
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.registerSystem(toRegister);
        assertEquals(expResult, result);
    }

    /**
     * Test of RequestToExit method, of class Administrator.
     */
    @Test
    public void testRequestToExit() {
        System.out.println("RequestToExit");
        Object fromHere = new CourseSystem();
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.RequestToExit(fromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of appointTeacher method, of class Administrator.
     */
    @Test
    public void testAppointTeacher() {
        System.out.println("appointTeacher");
        Teacher thisTeacher = new Teacher();
        Course addedCourse = new Course();
        Administrator instance = new Administrator();
        instance.addCourse(addedCourse);
        boolean expResult = true;
        boolean result = instance.appointTeacher(thisTeacher, addedCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveUser method, of class Administrator.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("RemoveUser");
        User deleted = new Student("deneme");
        Object deletedFromHere = new CourseSystem()  ;
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.RemoveUser(deleted, deletedFromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUser method, of class Administrator.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User added = new Student("deneme");
        Object addedFromHere = new CourseSystem()  ;
        Administrator instance = new Administrator();
        instance.InstallSystem((CourseSystem)addedFromHere);
        boolean expResult = true;
        boolean result = instance.addUser(added, addedFromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCourse method, of class Administrator.
     */
    @Test
    public void testAddCourse() {
        System.out.println("addCourse");
        Course added = new Course("course1");
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.addCourse(added);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCourse method, of class Administrator.
     */
    @Test
    public void testRemoveCourse() {
        System.out.println("removeCourse");
        Course deleted = new Course("course1");
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.removeCourse(deleted);
        assertEquals(expResult, result);
    }

    /**
     * Test of controlled method, of class Administrator.
     */
    @Test
    public void testControlled_Object() {
        System.out.println("controlled");
        Object fromHere = new CourseSystem();
        Administrator instance = new Administrator();
        instance.InstallSystem((CourseSystem)fromHere);
        instance.controlled(fromHere);
    }

    /**
     * Test of controlled method, of class Administrator.
     */
    @Test
    public void testControlled_0args() {
        System.out.println("controlled");
        Administrator instance = new Administrator();
        instance.InstallSystem(new CourseSystem());
        instance.controlled();
    }

    /**
     * Test of listOfCourses method, of class Administrator.
     */
    @Test
    public void testListOfCourses() {
        System.out.println("listOfCourses");
        Administrator instance = new Administrator();
        instance.listOfCourses();
    }

    /**
     * Test of listOfUser method, of class Administrator.
     */
    @Test
    public void testListOfUser() {
        System.out.println("listOfUser");
        Object InThis = new CourseSystem();
        Administrator instance = new Administrator();
        instance.InstallSystem((CourseSystem)InThis);
        instance.listOfUser(InThis);
    }
    
}
