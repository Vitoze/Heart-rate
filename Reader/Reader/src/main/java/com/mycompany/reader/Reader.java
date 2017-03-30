/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reader;

import Sender.ISend;
import Sender.Sender;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author Daniel Oliveira
 */
public class Reader {

    static final int SAMPLES_PER_CHUNK = 500;
    static final String DEFAULT_FILE = "VitalJacket_ECG.tsv";
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public static void main(String[] args) {
        boolean endReader = false;
        boolean endCicle = false;
        ECGReader fr = null;
        String file;
        ISend sender = new Sender();//TODO: Initialize an object that implements ISender
        
        // Get the file name to read from
        if (args == null) { // If there are no arguments
            file = DEFAULT_FILE;
        } else { // If the user provided and argument
            file = args[0];
        }
        
        // Instanciate the ECGReader
        try {
            fr = new ECGReader("VitalJacket_ECG.tsv");
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("File not found, you faggot! Programm will close now.");
            System.exit(1);
        }

        while (!endReader) {
            JSONObject stream = new JSONObject();
            String values = "";

            // Read from the file and add to the values
            for (int i = 0; (i < SAMPLES_PER_CHUNK) || !endReader; i++) {
                double value = fr.getNextValue();
                if (value == -1) {
                    endReader = true;
                    //endReader ?
                } else {
                    values += value;
                }
            }

            //TODO: put the values in the stream
            stream.put("values", values);
            stream.put("timestamp", getCurrentTime());
            
            //TODO: send the result
        }
        System.out.println("Job's done. Reader closing.");
    }
    
    protected static String getCurrentTime () {
        return dateFormat.format(new Date());
    }
}
