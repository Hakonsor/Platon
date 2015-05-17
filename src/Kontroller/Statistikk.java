/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import Forsikring.Forsikringer;
import SkadeMeldinger.SkadeMelding;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

/**
 *
 * @author hakon_000
 */
public class Statistikk {

    //defining the axes
    final LineChart<String, Number> lineChart;
    XYChart.Series series = new XYChart.Series();
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    String datanavn = "Forsikringer";
    String månder[] = {"Jan", "Feb", "Mar", "Apr", "May",
        "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

    public Statistikk(String title) {

        xAxis.setLabel("Number of Month");
        //creating the chart
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(title);
        //defining a series

        series.setName(datanavn);
        //populating the series with data

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

    }

    public LineChart getGraf() {
        return lineChart;
    }

    public void soterMånedSkademeldinger(List list) {
        List<SkadeMelding> liste = list;
        liste.stream().forEach((s) -> {
            if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.JANUARY) {
                jan += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.FEBRUARY) {
                feb += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.MARCH) {
                mar += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.APRIL) {
                apr += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.MAY) {
                may += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.JUNE) {
                jun += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.JULY) {
                jul += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.AUGUST) {
                aug += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.SEPTEMBER) {
                sep += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.OCTOBER) {
                oct += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.NOVEMBER) {
                nov += s.getUtbetaling();
            } else if (s.getdatoInnmeldt().get(Calendar.MONTH) == Calendar.DECEMBER) {
                dec += s.getUtbetaling();
            }// ser ut som unødvending mye code, men er jeg for sliten til å være kreativ
        });

    }

    public void soterMånedForsikringer(List list) {
        List<Forsikringer> liste = list;
        liste.stream().forEach((s) -> {
            if (s.getStartDato().get(Calendar.MONTH) == Calendar.JANUARY) {
                jan += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.FEBRUARY) {
                feb += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.MARCH) {
                mar += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.APRIL) {
                apr += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.MAY) {
                may += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.JUNE) {
                jun += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.JULY) {
                jul += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.AUGUST) {
                aug += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.SEPTEMBER) {
                sep += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.OCTOBER) {
                oct += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.NOVEMBER) {
                nov += s.getPremie();
            } else if (s.getStartDato().get(Calendar.MONTH) == Calendar.DECEMBER) {
                dec += s.getPremie();
            }// ser ut som unødvending mye code, men er jeg for sliten til å være kreativ
        });

    }

    public void måndeData(List list) {

        if (list != null && !list.isEmpty() && list.get(0) instanceof SkadeMelding) {
            soterMånedSkademeldinger(list);
        }else if (list != null && !list.isEmpty() && list.get(0) instanceof Forsikringer) {
            soterMånedForsikringer(list);
        }
        //opptatterGraf();
    }

    public void opptatterGraf() {
        series.getData().add(new XYChart.Data("Jan", jan));
        series.getData().add(new XYChart.Data("Feb", feb));
        series.getData().add(new XYChart.Data("Mar", mar));
        series.getData().add(new XYChart.Data("Apr", apr));
        series.getData().add(new XYChart.Data("May", may));
        series.getData().add(new XYChart.Data("Jun", jun));
        series.getData().add(new XYChart.Data("Jul", jul));
        series.getData().add(new XYChart.Data("Aug", aug));
        series.getData().add(new XYChart.Data("Sep", sep));
        series.getData().add(new XYChart.Data("Oct", oct));
        series.getData().add(new XYChart.Data("Nov", nov));
        series.getData().add(new XYChart.Data("Dec", dec));
    }

    private void opptatterMånder(List list) {

    }
}
