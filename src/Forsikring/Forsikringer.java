/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Person.Kunde;
import java.util.Calendar;

/**
 *
 * @author Therese, H�kon
 */
public abstract class Forsikringer implements Serializable{
    private boolean aktiv;
    private Kunde kunde;
    private int poliseNr;
    private static int nestePolisNr = 100000;
    private double premie;
    private double egenandel;
    private Calendar startDato;
    private Calendar sluttDato;
    private List<Integer> innbetalinger  = new ArrayList();
    
    public Forsikringer() {
        poliseNr = ++nestePolisNr;
        aktiv =true; 
        
    }
    // brukes når det registreres kjøretøy.
    public Forsikringer( double premie, double egenandel ){
       this();
       this.premie = premie;
       this.egenandel = egenandel;

    }
    
    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }
    
     public Kunde getKunde(){
        return kunde;
    }
   
    public int getPoliseNr(){
       return poliseNr;
   }
   
     public double getPremie(){
        return premie;
     }
    
     
     public void setPremie(double premie){
       this.premie = premie;
   }
    
    
   
    public double getEgenAndel(){
       return egenandel;
   }
    
    public void setStartDato( Calendar startDato ){
       this.startDato = startDato;
       
    }
   
    public void setSluttDato( Calendar sluttDato ){
       this.sluttDato = sluttDato;
       
    }
   
    public Calendar getStartDato(){
       return startDato;
   }
   
    public Calendar getSluttDato(){
       return sluttDato;
   } 
    
    public String toString(){
        String s = "Polisenummer: " + poliseNr + "\nPremie: "
        + premie + "\nEgenandel: " + egenandel  +
        "\nGjelder fra: " +  startDato;
            return s;
    }
    
    // metoden sammenligner på poliseNr for å avgjøre om de er like
    public boolean equals(Forsikringer f){
       return ( f.getPoliseNr() == ( poliseNr) );
       }
    
   
 }// end of abstract class Forsikringer
