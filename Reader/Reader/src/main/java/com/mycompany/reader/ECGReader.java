/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Daniel Oliveira
 */
public class ECGReader {

    File f;
    Scanner sc;
    boolean header = true;

    public ECGReader(String filename) throws FileNotFoundException {
        f = new File(filename);
        sc = new Scanner(f);
    }

    public double getNextValue() {
        if (header) {
            //TODO Check the name
            sc.nextLine();
            header = false;
        }
        
        if (sc.hasNext()) {
            return Double.parseDouble(sc.nextLine());
        }
    return -1;
    }

}
