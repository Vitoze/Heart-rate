/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reader;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ECGReaderTest {

    public ECGReaderTest() {
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
     * Test of getNextValue method, of class ECGReader.
     */
    @org.junit.Test
    public void testGetNextValue() {
        System.out.println("getNextValue");
        double[] expResult = {125.0, 125.0, 125.0, 123.0, 123.0};

        ECGReader instance;

        try {
            instance = new ECGReader("VitalJacket_ECG.tsv");
            for (double er : expResult) {
                double result = instance.getNextValue();
                System.out.println("r: " + result);
                if (er != result) {
                    fail("Unexpected result faggot");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ECGReaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

