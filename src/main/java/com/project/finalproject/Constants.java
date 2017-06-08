/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;

/**
 *
 * @author DanyOctrome
 */
public class Constants {
    static protected int countH = 0;
    static protected int countL = 0;
    
    public static synchronized void incrementAlarmHigh () {
        countH++;
    }
    
    public static synchronized void incrementAlarmLow () {
        countL++;
    }
    
    public static synchronized int getCountH () {
        return countH;
    }
    
    public static synchronized int getCountL () {
        return countL;
    }
}
