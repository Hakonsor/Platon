/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import java.util.List;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author hakon_000
 */
public class Statistikk {
    
          
        //defining the axes
        XYChart.Series series = new XYChart.Series();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        String datanavn = "";
        String månder[] = {"Jan", "Feb", "Mar", "Apr", "May",
            "Jun", "Aug", "Sep", "Oct", "Nov", "Dec" };
        
        
        public Statistikk(){

        Stream<String> stream = Stream.of(månder);
        
        
        
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String,Number> lineChart = 
                new LineChart<>(xAxis,yAxis);
                
        lineChart.setTitle("Forsikringer Monitoring, 2015");
        //defining a series
        
        series.setName(datanavn);
        //populating the series with data
       
        
        series.getData().add(new XYChart.Data("s", 23));
        series.getData().add(new XYChart.Data("Feb", 14));
        series.getData().add(new XYChart.Data("Mar", 15));
        series.getData().add(new XYChart.Data("Apr", 24));
        series.getData().add(new XYChart.Data("May", 34));
        series.getData().add(new XYChart.Data("Jun", 36));
        series.getData().add(new XYChart.Data("Jul", 22));
        series.getData().add(new XYChart.Data("Aug", 45));
        series.getData().add(new XYChart.Data("Sep", 43));
        series.getData().add(new XYChart.Data("Oct", 17));
        series.getData().add(new XYChart.Data("Nov", 29));
        series.getData().add(new XYChart.Data("Dec", 25));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        
        }
        public void måndeData(List liste){
        
        for(String månde : månder){
        //series.getData().add(new XYChart.Data(månde));
        }
        }
       
        
}
