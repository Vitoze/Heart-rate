/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reader;

import org.json.JSONObject;
import java.lang.System;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DanyOctrome
 */
public class Reader {

    static final int samplesPerChunk = 500;

    public static void main(String[] args) {
        boolean endReader = false;
        boolean endCicle = false;
        ECGReader fr;
        //JSONObject obj = new JSONObject();

        while (!endReader) {
            JSONObject stream = new JSONObject();
            String values = "";
            
            try {
                fr = new ECGReader("VitalJacket_ECG.tsv");
                
                // TODO: add the header stream
            } catch (Exception ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            // Read from the file and add to the values
            for (int i = 0; (i < samplesPerChunk) || !endCicle; i++) {
                double value = fr.getNextValue();
                if (value == -1) {
                    endCicle = true;
                    //endReader ?
                } else {
                    values += value;
                }
            }

            //TODO: put the values in the stream
        }
        System.out.println("Reader closing.");
    }
}
