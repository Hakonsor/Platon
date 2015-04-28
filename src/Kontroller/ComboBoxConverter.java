/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ComboBox;

/**
 *
 * @author hakon_000
 */
public interface ComboBoxConverter {

    default double boxConverterer(ComboBox<String> box, int øvreGrense, int nedreGrense) {
        String x = box.getValue();
        String y = x.substring(øvreGrense, x.length() - nedreGrense);
        y = y.replaceAll("\\s", "");
        return Double.parseDouble(y);
    }
    
    default double convertDou(String s) {

        s = s.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("(-?[0-9]+)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        }else
            System.out.println("ERROR i comboconverter");
        return -1;
        
        }
       
        default int convertInt(String s){
            s = s.substring(0, s.length()-1);
            return Integer.parseInt(s.replaceAll("[^0-9]", ""));
        }
}
