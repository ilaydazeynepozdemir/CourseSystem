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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of uploadAssignment method, of class Student.
     */
    @Test
    public void testUploadAssignment() {
        System.out.println("uploadAssignment");
        Course ToThisCourse = new Course();
        int numOfAssignment = 0;
        Assignment Student_Assignment = new Homework("adi", new File());
        Student instance = new Student();
        instance.uploadAssignment(ToThisCourse, numOfAssignment, Student_Assignment);
        
        boolean expResult = false;
        boolean result = instance.uploadAssignment(ToThisCourse, numOfAssignment, Student_Assignment);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewMyGrades method, of class Student.
     */
    @Test
    public void testViewMyGrades() {
        System.out.println("viewMyGrades");
        Course ThisCourse = new Course();
        Student instance = new Student();
        instance.viewMyGrades(ThisCourse);
    }

    /**
     * Test of viewAllGrades method, of class Student.
     */
    @Test
    public void testViewAllGrades() {
        System.out.println("viewAllGrades");
        Student instance = new Student();
        instance.viewAllGrades();
    }

    /**
     * Test of enrolMe_InCourse method, of class Student.
     */
    @Test
    public void testEnrolMe_InCourse() {
        System.out.println("enrolMe_InCourse");
        Course enrolThisCourse = new Course();
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.enrolMe_InCourse(enrolThisCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfStudent_InCourse method, of class Student.
     */
    @Test
    public void testSetNumberOfStudent_InCourse() {
        System.out.println("setNumberOfStudent_InCourse");
        int given = 0;
        Student instance = new Student();
        instance.setNumberOfStudent_InCourse(given);
    }

    /**
     * Test of getNumberOfStudent_InCourse method, of class Student.
     */
    @Test
    public void testGetNumberOfStudent_InCourse() {
        System.out.println("getNumberOfStudent_InCourse");
        Student instance = new Student();
        int expResult = 0;
        int result = instance.getNumberOfStudent_InCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of listOfAssignments_StudentHas method, of class Student.
     */
    @Test
    public void testListOfAssignments_StudentHas() {
        System.out.println("listOfAssignments_StudentHas");
        Student instance = new Student();
        instance.listOfAssignments_StudentHas();
    }

    /**
     * Test of listOfAssingment_uploaded method, of class Student.
     */
    @Test
    public void testListOfAssingment_uploaded() {
        System.out.println("listOfAssingment_uploaded");
        Course InThisCourse = new Course();
        Student instance = new Student();
        instance.listOfAssingment_uploaded(InThisCourse);
    }

    /**
     * Test of RequestToExit method, of class Student.
     */
    @Test
    public void testRequestToExit() {
        System.out.println("RequestToExit");
        Object fromHere = new CourseSystem();
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.RequestToExit(fromHere);
        assertEquals(expResult, result);
    }
    
}
