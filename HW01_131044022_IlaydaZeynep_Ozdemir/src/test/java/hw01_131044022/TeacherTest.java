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
public class TeacherTest {
    
    public TeacherTest() {
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
     * Test of addUser method, of class Teacher.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User added = new Student();
        Object addedToHere = new Course("course");
        Teacher instance = new Teacher();
        boolean expResult = true;
        boolean result = instance.addUser(added, addedToHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveUser method, of class Teacher.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("RemoveUser");
        User deleted = new Student();
        Object deletedFromHere = new Course();
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.RemoveUser(deleted, deletedFromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Teacher.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Teacher given = new Teacher();
        Teacher instance = new Teacher();
        boolean expResult = true;
        boolean result = instance.equals(given);
        assertEquals(expResult, result);
    }

    /**
     * Test of giveAssignment method, of class Teacher.
     */
    @Test
    public void testGiveAssignment() {
        System.out.println("giveAssignment");
        Assignment givenFromTeacher = new Homework("adi", new File());
        Course InthisCourse = new Course();
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.giveAssignment(givenFromTeacher, InthisCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewOlderCourse method, of class Teacher.
     */
    @Test
    public void testViewOlderCourse() {
        System.out.println("viewOlderCourse");
        Teacher instance = new Teacher();
        instance.viewOlderCourse();
    }

    /**
     * Test of listOfAssignment_uploaded method, of class Teacher.
     */
    @Test
    public void testListOfAssignment_uploaded() {
        System.out.println("listOfAssignment_uploaded");
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.listOfAssignment_uploaded(InThisCourse);
    }



    /**
     * Test of RequestToExit method, of class Teacher.
     */
    @Test
    public void testRequestToExit() {
        System.out.println("RequestToExit");
        Object fromHere = new Course();
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.RequestToExit(fromHere);
        assertEquals(expResult, result);
    }

    /**
     * Test of controlled method, of class Teacher.
     */
    @Test
    public void testControlled() {
        System.out.println("controlled");
        Object fromHere = new Course();
        Teacher instance = new Teacher();
        instance.controlled(fromHere);
    }

    /**
     * Test of editDeadlines method, of class Teacher.
     */
    @Test
    public void testEditDeadlines() {
        System.out.println("editDeadlines");
        int newDay_forAssignment = 0;
        int numOfAssingment = 0;
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.editDeadlines(newDay_forAssignment, numOfAssingment, InThisCourse);
    }

    /**
     * Test of graded_AllCourses method, of class Teacher.
     */
    @Test
    public void testGraded_AllCourses() {
        System.out.println("graded_AllCourses");
        Teacher instance = new Teacher();
        instance.graded_AllCourses();
    }

    /**
     * Test of graded_InThisCourse method, of class Teacher.
     */
    @Test
    public void testGraded_InThisCourse() {
        System.out.println("graded_InThisCourse");
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.graded_InThisCourse(InThisCourse);
    }

    /**
     * Test of addTutor_InCourse method, of class Teacher.
     */
    @Test
    public void testAddTutor_InCourse() {
        System.out.println("addTutor_InCourse");
        Student addedTutor = new Student();
        Course ThisCourse = new Course();
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.addTutor_InCourse(addedTutor, ThisCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTutor_InCourse method, of class Teacher.
     */
    @Test
    public void testRemoveTutor_InCourse() {
        System.out.println("removeTutor_InCourse");
        Tutor deleted = new Tutor();
        Course ThisCourse = new Course();
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeTutor_InCourse(deleted, ThisCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of listOfTutor method, of class Teacher.
     */
    @Test
    public void testListOfTutor() {
        System.out.println("listOfTutor");
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.listOfTutor(InThisCourse);
    }

    /**
     * Test of listOfUser method, of class Teacher.
     */
    @Test
    public void testListOfUser() {
        System.out.println("listOfUser");
        Object InThis = new Course();
        Teacher instance = new Teacher();
        instance.listOfUser(InThis);
    }

    /**
     * Test of addDocument_InCourse method, of class Teacher.
     */
    @Test
    public void testAddDocument_InCourse() {
        System.out.println("addDocument_InCourse");
        Document addedDoc = new File();
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.addDocument_InCourse(addedDoc, InThisCourse);
    }

    /**
     * Test of removeDocument_InCourse method, of class Teacher.
     */
    @Test
    public void testRemoveDocument_InCourse() {
        System.out.println("removeDocument_InCourse");
        Document deletedDoc = new File();
        Course InThisCourse = new Course();
        Teacher instance = new Teacher();
        instance.removeDocument_InCourse(deletedDoc, InThisCourse);
    }
    
}
