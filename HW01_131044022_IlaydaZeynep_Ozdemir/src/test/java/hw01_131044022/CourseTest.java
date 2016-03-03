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
public class CourseTest extends TestCase {

    public CourseTest() {
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
     * Test of getDocumentsOfCourse method, of class Course.
     */
    @Test
    public void testGetDocumentsOfCourse_int() {
        System.out.println("getDocumentsOfCourse");
        int index = 0;
        Course instance = new Course();
        Document expResult = new File();
        instance.DocumentsOfCourse = new ArrayList<>();
        instance.DocumentsOfCourse.add(expResult);
        Document result = instance.getDocumentsOfCourse(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDocumentsOfCourse method, of class Course.
     */
    @Test
    public void testGetDocumentsOfCourse_0args() {
        System.out.println("getDocumentsOfCourse");
        Course instance = new Course();
        ArrayList<Document> expResult = new ArrayList<>();
        instance.DocumentsOfCourse = expResult;
        ArrayList<Document> result = instance.getDocumentsOfCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeacherOfcourse method, of class Course.
     */
    @Test
    public void testSetTeacherOfcourse() {
        System.out.println("setTeacherOfcourse");
        Teacher givenTeacher = new Teacher();
        Course instance = new Course();
        instance.setTeacherOfcourse(givenTeacher);
    }

    /**
     * Test of setCourseName method, of class Course.
     */
    @Test
    public void testSetCourseName() {
        System.out.println("setCourseName");
        String TakenName = "courseName";
        Course instance = new Course();
        instance.setCourseName(TakenName);
    }

    /**
     * Test of addUsersOfCourse method, of class Course.
     */
    @Test
    public void testAddUsersOfCourse() {
        System.out.println("addUsersOfCourse");
        User addedUser = new Student();
        Course instance = new Course();
        instance.addUsersOfCourse(addedUser);
    }

    /**
     * Test of setAssignmentsOfCourse_givenTeacher method, of class Course.
     */
    @Test
    public void testSetAssignmentsOfCourse_givenTeacher() {
        System.out.println("setAssignmentsOfCourse_givenTeacher");
        Assignment givenTeacher = new Homework();
        int numOfAssignment = 0;
        Course instance = new Course();
        instance.setAssignmentsOfCourse_givenTeacher(givenTeacher, numOfAssignment);
    }

    /**
     * Test of increaseNumberOfStudents method, of class Course.
     */
    @Test
    public void testIncreaseNumberOfStudents() {
        System.out.println("increaseNumberOfStudents");
        Course instance = new Course();
        instance.increaseNumberOfStudents();
    }

    /**
     * Test of addAssignmentsOfCourse_givenTeacher method, of class Course.
     */
    @Test
    public void testAddAssignmentsOfCourse_givenTeacher() {
        System.out.println("addAssignmentsOfCourse_givenTeacher");
        Assignment givenTeacher = new Homework();
        Course instance = new Course();
        instance.addAssignmentsOfCourse_givenTeacher(givenTeacher);
    }

    /**
     * Test of getAssignmentsOfCourse_givenTeacher method, of class Course.
     */
    @Test
    public void testGetAssignmentsOfCourse_givenTeacher() {
        System.out.println("getAssignmentsOfCourse_givenTeacher");
        int numOfAssignment = 0;
        Course instance = new Course();
        Assignment expResult = new Homework();
        instance.setAssignmentsOfCourse_givenTeacher(expResult, numOfAssignment);
        Assignment result = instance.getAssignmentsOfCourse_givenTeacher(numOfAssignment);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTutorsOfCourse method, of class Course.
     */
    @Test
    public void testGetTutorsOfCourse() {
        System.out.println("getTutorsOfCourse");
        Course instance = new Course();
        ArrayList<Tutor> expResult =instance.getTutorsOfCourse();
        expResult.add(new Tutor());
        ArrayList<Tutor> result = instance.getTutorsOfCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTutorsOfCourse method, of class Course.
     */
    @Test
    public void testAddTutorsOfCourse() {
        System.out.println("addTutorsOfCourse");
        Tutor added = new Tutor();
        Course instance = new Course();
        instance.addTutorsOfCourse(added);
    }

    /**
     * Test of getTeacherOfcourse method, of class Course.
     */
    @Test
    public void testGetTeacherOfcourse() {
        System.out.println("getTeacherOfcourse");
        Course instance = new Course();
        Teacher expResult = new Teacher();
        instance.setTeacherOfcourse(expResult);
        Teacher result = instance.getTeacherOfcourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfStudents method, of class Course.
     */
    @Test
    public void testGetNumberOfStudents() {
        System.out.println("getNumberOfStudents");
        Course instance = new Course();
        int expResult = 0;
        int result = instance.getNumberOfStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsersOfCourse method, of class Course.
     */
    @Test
    public void testGetUsersOfCourse() {
        System.out.println("getUsersOfCourse");
        Course instance = new Course();
        ArrayList<User> expResult = new ArrayList<>();
        ArrayList<User> result = instance.getUsersOfCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName() {
        System.out.println("getCourseName");
        Course instance = new Course();
        String expResult = "courseName";
        instance.setCourseName(expResult);
        String result = instance.getCourseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_userOfCourse method, of class Course.
     */
    @Test
    public void testGet_userOfCourse() {
        System.out.println("get_userOfCourse");
        int index = 0;
        Course instance = new Course();
        User expResult = new Student();
        instance.addUsersOfCourse(expResult);
        User result = instance.get_userOfCourse(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize_usersOfCourse method, of class Course.
     */
    @Test
    public void testGetSize_usersOfCourse() {
        System.out.println("getSize_usersOfCourse");
        Course instance = new Course();
        int expResult = 0;
        int result = instance.getSize_usersOfCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of removedUser method, of class Course.
     */
    @Test
    public void testRemovedUser() {
        System.out.println("removedUser");
        User deleted = new Student();
        Course instance = new Course();
        instance.removedUser(deleted);
    }

    /**
     * Test of lastAddedUser method, of class Course.
     */
    @Test
    public void testLastAddedUser() {
        System.out.println("lastAddedUser");
        Course instance = new Course();
        User expResult = new Student();
        instance.addUsersOfCourse(expResult);
        User result = instance.lastAddedUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of listOfUsers_InCourse method, of class Course.
     */
    @Test
    public void testListOfUsers_InCourse() {
        System.out.println("listOfUsers_InCourse");
        Course instance = new Course();
        instance.listOfUsers_InCourse();
    }

    /**
     * Test of listOfAssignments_InCourse method, of class Course.
     */
    @Test
    public void testListOfAssignments_InCourse() {
        System.out.println("listOfAssignments_InCourse");
        Course instance = new Course();
        instance.listOfAssignments_InCourse();
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Course instance = new Course();
        String expResult = "deneme";
       instance.setCourseName(expResult);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Course.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object given = new Course();
        Course instance = new Course();
        boolean expResult = true;
        boolean result = instance.equals(given);
        assertEquals(expResult, result);
    }

    /**
     * Test of setWishForExit method, of class Course.
     */
    @Test
    public void testSetWishForExit() {
        System.out.println("setWishForExit");
        boolean wish = false;
        Course instance = new Course();
        instance.setWishForExit(wish);
    }

    /**
     * Test of getWishForExit_teacher method, of class Course.
     */
    @Test
    public void testGetWishForExit_teacher() {
        System.out.println("getWishForExit_teacher");
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.getWishForExit_teacher();
        assertEquals(expResult, result);
    }

}
