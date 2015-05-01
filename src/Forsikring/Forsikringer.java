/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;
import java.util.List;
import Person.Kunde;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Forsikringer implements Serializable{
    protected boolean aktiv;
    protected Kunde kunde;
    protected int poliseNr;
    protected static int nestePoliseNr = 100000;
    protected double premie;
    protected double egenandel;
    protected Calendar startDato;
    protected Calendar sluttDato;
    
    public Forsikringer() {
        poliseNr = ++nestePoliseNr;
        aktiv =true; 
        
    }
    // brukes når det registreres kjøretøy.
    public Forsikringer( double premie, double egenandel ){
       this();
       this.premie = premie;
       this.egenandel = egenandel;
       aktiv = true;
    }
    
    // legger peker til kunden som har denne forsikringen
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
