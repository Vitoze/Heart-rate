/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;

import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Daniel Oliveira
 */
public class SharedChart {
    private static LineChartModel chart = new LineChartModel();
    private static final ChartSeries cs = new ChartSeries();
    private static int count = 0;
    
    public synchronized static void setChart(LineChartModel chart) {
        SharedChart.chart = chart;
    }
    
    public synchronized static LineChartModel getChart () {
        return chart;
    }

    public synchronized static void updateChart(int value) {
        LineChartModel model = new LineChartModel();

        //cs.set(new SimpleDateFormat("HHmmss").format(new Date()), Integer.parseInt(value.replaceAll(".0", "")));
        //cs.set(count++, value);
        
        Map<Object, Number> temp = cs.getData();
        temp.put(count++, value);
        //temp.remove(count-70);
        cs.setData(temp);
        
        model.setTitle("Heart Rate Chart");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Time"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Heart Rate");
        yAxis.setMin(-5);
        yAxis.setMax(200);
        
        model.addSeries(cs);
        
        chart = model;
    }
}
