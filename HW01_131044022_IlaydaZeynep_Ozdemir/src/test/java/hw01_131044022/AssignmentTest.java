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
public class AssignmentTest {

    public AssignmentTest() {
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
     * Test of setAssignmentTime method, of class Assignment.
     */
    @Test
    public void testSetAssignmentTime() {
        System.out.println("setAssignmentTime");
        int givenAssignmentTime = 0;
        Assignment instance = new Homework();
        instance.setAssignmentTime(givenAssignmentTime);
    }

    /**
     * Test of getAssignmentTime method, of class Assignment.
     */
    @Test
    public void testGetAssignmentTime() {
        System.out.println("getAssignmentTime");
        Assignment instance = new Homework();
        int expResult = 7;//default assignment time 7
        int result = instance.getAssignmentTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAssignmentName method, of class Assignment.
     */
    @Test
    public void testSetAssignmentName() {
        System.out.println("setAssignmentName");
        String Name = "yeniAd";
        Assignment instance = new Homework();
        instance.setAssignmentName(Name);
    }

    /**
     * Test of getAssignmentName method, of class Assignment.
     */
    @Test
    public void testGetAssignmentName() {
        System.out.println("getAssignmentName");
        Document doc1 = new File();
        Assignment instance = new Homework("denemeAdi", doc1);
        String expResult = "denemeAdi";
        String result = instance.getAssignmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addDocumentOfStudents method, of class Assignment.
     */
    @Test
    public void testAddDocumentOfStudents() {
        System.out.println("addDocumentOfStudents");
        Document DocOfStudent = new File();
        Assignment instance = new Homework("deneme",DocOfStudent);
        instance.addDocumentOfStudents(DocOfStudent);
    }

    /**
     * Test of getDocumentOfStudents method, of class Assignment.
     */
    @Test
    public void testGetDocumentOfStudents() {
        System.out.println("getDocumentOfStudents");
        int index = 0;
        Document expResult = new File();
        Assignment instance = new Homework("adi", expResult);
        Document result = instance.getDocumentOfStudents(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDocumentOfTeacher method, of class Assignment.
     */
    @Test
    public void testSetDocumentOfTeacher() {
        System.out.println("setDocumentOfTeacher");
        Document DocOfTeacher = new File();
        Assignment instance = new Homework();
        instance.setDocumentOfTeacher(DocOfTeacher);
    }

    /**
     * Test of getDocumentOfTeacher method, of class Assignment.
     */
    @Test
    public void testGetDocumentOfTeacher() {
        System.out.println("getDocumentOfTeacher");
        Assignment instance = new Homework();
        Document expResult = new File();
        instance.setDocumentOfTeacher(expResult);
        Document result = instance.getDocumentOfTeacher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGrade method, of class Assignment.
     */
    @Test
    public void testSetGrade() {
        System.out.println("setGrade");
        int givenGrade = 0;
        Assignment instance = new Homework();
        instance.setGrade(givenGrade);
    }

    /**
     * Test of getGrade method, of class Assignment.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        Assignment instance = new Homework();
        int expResult = 0;
        instance.setGrade(expResult);
        int result = instance.getGrade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeadlines method, of class Assignment.
     */
    @Test
    public void testGetDeadlines() {
        System.out.println("getDeadlines");
        Deadline expResult = new Deadline(5);
        Assignment instance = new Homework("adi", new File(), expResult);
        Deadline result = instance.getDeadlines();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Assignment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object thisAssignment = new Homework("deneme",new File(),5);
        Assignment instance = new Homework("deneme",new File(),5);
        boolean expResult = true;
        boolean result = instance.equals(thisAssignment);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Assignment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "deneme";
        Assignment instance = new Homework(expResult,new File());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
