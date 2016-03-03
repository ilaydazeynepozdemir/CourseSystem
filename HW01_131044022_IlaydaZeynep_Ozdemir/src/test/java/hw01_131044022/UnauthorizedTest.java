/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

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
public class UnauthorizedTest extends TestCase{
    
    public UnauthorizedTest() {
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
     * Test of enrolMe_InCourse method, of class Unauthorized.
     */
    @Test
    public void testEnrolMe_InCourse() {
        System.out.println("enrolMe_InCourse");
        Course enrolThisCourse = new Course();
        Unauthorized instance = new Student();
        boolean expResult = false;
        boolean result = instance.enrolMe_InCourse(enrolThisCourse);//hocasi yok
        assertEquals(expResult, result);
    }

 
    
}
