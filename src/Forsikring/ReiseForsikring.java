/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring ;


import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class ReiseForsikring extends Forsikringer implements Serializable{
    private String type;
    public ReiseForsikring(){
        super(0, 0);
        setPremie(type);
        egenandel = egenAndel();
    }
    
    
    // om det er verden, europa eller norden
    public void setType(String type){
        this.type = type;
    }
    
    public void setPremie(String type){
        if(type.equals("Verden")){
            premie = 1700;
        }
        else if(type.equalsIgnoreCase("Europa")){
            premie = 1400;
        }
        else if(type.equalsIgnoreCase("Europa")){
            premie = 900;
        }
    }
    
    private double egenAndel(){
        egenandel = 300;
        return egenandel;
    }
    
    

    
    
   
}// end of class ForsikringsPremie.