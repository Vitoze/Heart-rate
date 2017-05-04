/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.human.ecg.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daniel Oliveira
 */
public class ReadJSON {
    String filePath;
    JSONArray jArray;
    JSONParser parser = new JSONParser();
    
    public ReadJSON (String filePath) throws FileNotFoundException, IOException, ParseException {
        jArray = (JSONArray) parser.parse(new FileReader(filePath));
    }
    
    public JSONArray getArray () {
        return jArray;
    }
}
