/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author Marco Macedo
 */
public class HR_steps {
    
    String hr_peak;
    finalBean fb; 
    
    
    @Given("^HR peak$")
    public void gimmeHR() {
        hr_peak = fb.getValue();
    }

    @When("^When HR peak > '(\\d*)'$")
    public void checkValue() {
         if(Integer.parseInt(hr_peak)> 150){
             fb.setValue(hr_peak);
         }
    }

    @Then("^Then Alarm count should increase. $")
    public void alarmcount(final char count) {
        //assertThat(hr_peak, is(count));
    }
}
