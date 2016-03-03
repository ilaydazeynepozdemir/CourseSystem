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
public class GroupProjectTest {
    
    public GroupProjectTest() {
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
     * Test of FillTeamMate method, of class GroupProject.
     */
    @Test
    public void testFillTeamMate() {
        System.out.println("FillTeamMate");
        User forTeam = new Student();
        GroupProject instance = new GroupProject("deneme", new File() );
        instance.FillTeamMate(forTeam);
    }

    /**
     * Test of getTeamMate method, of class GroupProject.
     */
    @Test
    public void testGetTeamMate() {
        System.out.println("getTeamMate");
        int index = 0;
        GroupProject instance = new GroupProject("deneme", new File());
        User expResult = new Student("ogrenci1");
        User expResult2 = new Student("ogrenci2");
        instance.FillTeamMate(expResult);
        instance.FillTeamMate(expResult2);
        User result = instance.getTeamMate(index);
        assertEquals(expResult, result);
    }
    
}
