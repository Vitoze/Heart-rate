/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import com.rabbitmq.client.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author brito
 */
@Named(value = "finalBean")
@ApplicationScoped
public class finalBean {
    private final static String QUEUE_NAME = "hello";
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private Consumer consumer;
    private LineChartModel chart;
    private ChartSeries cs = new ChartSeries();
    private int count = 0;
    /**
     * Creates a new instance of finalBean
     */
    public finalBean(LineChartModel chart) throws IOException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        initConsumer();
        this.chart = chart;
        cs.setLabel("Heart Rate");
    }

    private void initConsumer() throws IOException{
        consumer = new DefaultConsumer(channel) {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        String message = new String(body, "UTF-8");
        setValue(message);
        setCView(message);
        System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
    }
    private String value;
    
    public void setValue(String v){
        value = v;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setCView(String value){
        LineChartModel model = new LineChartModel();

        //cs.set(new SimpleDateFormat("HHmmss").format(new Date()), Integer.parseInt(value.replaceAll(".0", "")));
        cs.set(count++, Integer.parseInt(value.replaceAll(".0", "")));
        
        Map<Object, Number> temp = cs.getData();
        
        model.setTitle("Heart Rate Chart");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Time"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Heart Rate");
        yAxis.setMin(-5);
        yAxis.setMax(200);
        
        model.addSeries(cs);
        SharedChart.setChart(model);
    }
}
