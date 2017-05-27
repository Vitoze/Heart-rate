/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;

import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Daniel Oliveira
 */
public class SharedChart {
    private static LineChartModel chart = new LineChartModel();
    
    public synchronized static void setChart(LineChartModel chart) {
        SharedChart.chart = chart;
    }
    
    public synchronized static LineChartModel getChart () {
        return chart;
    }
}
