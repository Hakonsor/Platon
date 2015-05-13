/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author hakon_000
 */
public class Kakediagram {

    ObservableList<PieChart.Data> pieChartData;
    PieChart chart = null;



    public Kakediagram(String Overskrivft) {
         
        
        pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Reise", 0),
                        new PieChart.Data("Bolig", 0),
                        new PieChart.Data("Fritids", 0),
                        new PieChart.Data("Båt", 0),
                        new PieChart.Data("Bil", 0));

        chart = new PieChart(pieChartData);
        chart.setTitle(Overskrivft);
          //((Group) scene.getRoot()).getChildren().add(chart);
    }
    
    public PieChart hentKake(){
    return chart;
    }
    

    public void setReise(Double value) {
        chart.getData().forEach(e -> {
            if (e.getName().equals("Reise")) {
                e.setPieValue(value);
            }
        });
    }

    public void setBolig(Double value) {
        chart.getData().forEach(e -> {
            if (e.getName().equals("Bolig")) {
                e.setPieValue(value);
            }
        });
    }

    public void setFritids(Double value) {
        chart.getData().forEach(e -> {
            if (e.getName().equals("Fritids")) {
                e.setPieValue(value);
            }
        });
    }

    public void setBåt(Double value) {
        chart.getData().forEach(e -> {
            if (e.getName().equals("Båt")) {
                e.setPieValue(value);
            }
        });
    }

    public void setBil(Double value) {
        chart.getData().forEach(e -> {
            if (e.getName().equals("Bil")) {
                e.setPieValue(value);
            }
        });
    }

}
