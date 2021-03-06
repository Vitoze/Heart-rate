package com.project.finalproject;

import java.io.IOException;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class chartView implements Serializable {

    private LineChartModel lineModel2;
    private HashMap<Integer, Number> data;
    private finalBean bean;
    private int count;
    private ChartSeries cs = new ChartSeries();

    ;

    @PostConstruct
    public void init() {
        createLineModels();
        data = new HashMap();
        count = 0;
        cs.setLabel("Heart Rate");
        try {
            bean = new finalBean(lineModel2);
        } catch (IOException ex) {
            Logger.getLogger(chartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LineChartModel getLineModel2() {
        return SharedChart.getChart();
    }

    private void createLineModels() {

        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Heart Rate Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Time"));
        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("heart rate");
        yAxis.setMin(-5);
        yAxis.setMax(200);
    }

    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);

        model.addSeries(girls);

        return model;
    }

    public void updateValues(int value) {
        LineChartModel model = new LineChartModel();

        cs.set(new SimpleDateFormat("HH.mm.ss").format(new Date()), value);

        model.addSeries(cs);
        SharedChart.setChart(model);
    }

    public String getCountH() {
        return Integer.toString(Constants.getCountH());
    }
    
    public String getCountL() {
        return Integer.toString(Constants.getCountL());
    }
}
