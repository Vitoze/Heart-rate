/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.finalproject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.json.*;
import org.apache.commons.io.IOUtils;

public class Send {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    
    try{
        InputStream is = new FileInputStream("hr.json");
        String jsontxt = IOUtils.toString(is);
        JSONObject jsonObject = new JSONObject(jsontxt);
        JSONArray stream = jsonObject.getJSONArray("stream");
        for(int i=0; i < stream.length(); i++){
            String message = stream.getJSONObject(i).getString("value");
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
            TimeUnit.SECONDS.sleep(1);
        }
    }catch(FileNotFoundException fe){
        fe.printStackTrace();
    }catch(Exception e){
        e.printStackTrace();
    }

    channel.close();
    connection.close();
  }
}