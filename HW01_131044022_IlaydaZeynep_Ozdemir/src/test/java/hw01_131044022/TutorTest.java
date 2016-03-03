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
public class TutorTest {
    
    public TutorTest() {
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
     * Test of viewOlderCourse method, of class Tutor.
     */
    @Test
    public void testViewOlderCourse() {
        System.out.println("viewOlderCourse");
        Tutor instance = new Tutor();
        instance.viewOlderCourse();
    }



    /**
     * Test of uploadAssignment method, of class Tutor.
     */
    @Test
    public void testUploadAssignment() {
        System.out.println("uploadAssignment");
        Course ToThisCourse = new Course();
        int numOfAssignment = 0;
        Assignment uploaded = new Homework();
        Tutor instance = new Tutor();
        boolean expResult = false;
        boolean result = instance.uploadAssignment(ToThisCourse, numOfAssignment, uploaded);
        assertEquals(expResult, result);
    }
    
}
