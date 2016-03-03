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
public class InterfaceCourseTest {

    public InterfaceCourseTest() {
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
     * Test of setTeacherOfcourse method, of class InterfaceCourse.
     */
    @Test
    public void testSetTeacherOfcourse() {
        System.out.println("setTeacherOfcourse");
        Teacher teacherforCourse = null;
        InterfaceCourse instance = new Course();
        instance.setTeacherOfcourse(teacherforCourse);
    }

    /**
     * Test of addUsersOfCourse method, of class InterfaceCourse.
     */
    @Test
    public void testAddUsersOfCourse() {
        System.out.println("addUsersOfCourse");
        User addedUser = new Student();
        InterfaceCourse instance = new Course();
        instance.addUsersOfCourse(addedUser);

    }

    /**
     * Test of setCourseName method, of class InterfaceCourse.
     */
    @Test
    public void testSetCourseName() {
        System.out.println("setCourseName");
        String TakenName = "adi";
        InterfaceCourse instance = new Course(TakenName);
        instance.setCourseName(TakenName);
    }

    /**
     * Test of setWishForExit method, of class InterfaceCourse.
     */
    @Test
    public void testSetWishForExit() {
        System.out.println("setWishForExit");
        boolean wish = false;
        InterfaceCourse instance = new Course();
        instance.setWishForExit(wish);
    }

}
