/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DanyOctrome
 */
public class ReaderTest {
    
    public ReaderTest() {
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
     * Test of main method, of class Reader.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Reader.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTime method, of class Reader.
     */
    @Test
    public void testGetCurrentTime() {
        System.out.println("getCurrentTime");
        //String expResult = "";
        String result = Reader.getCurrentTime();
        //assertEquals(expResult, result);
        System.out.println("The current time is: " + result);
    }
    
}
