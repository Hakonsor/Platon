/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Therese, H�kon
 */
public abstract class Forsikringer implements Serializable{
    private boolean aktiv;
    private int poliseNr;
    private static int nestePolisNr = 100000;
    private double premie;
    private double egenandel;
    private Date startDato;
    private Date sluttDato;

    public Forsikringer() {
        poliseNr = ++nestePolisNr;
        aktiv =true;
        
    }
    
    
    // brukes når det registreres kjøretøy.
   
    /*public Forsikringer( String s){
        
    }
    */
    public Forsikringer( double premie, double egenandel ){
       this();
       this.premie = premie;
       this.egenandel = egenandel;

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
    
    public void setStartDato( Date startDato ){
       this.startDato = startDato;
       
    }
   
    public void setSluttDato( Date sluttDato ){
       this.sluttDato = sluttDato;
       
    }
   
    public Date getStartDato(){
       return startDato;
   }
   
    public Date getSluttDato(){
       return sluttDato;
   } 
    
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Polisenummer: ");
    sb.append(poliseNr);
    sb.append("\nPremie: ");
    sb.append(premie);
    sb.append("\nEgenandel: ");
    sb.append(egenandel);
    sb.append("\nGjelder fra: ");
    sb.append(startDato);
    return sb.toString();
    }
    
    public boolean equals(Forsikringer f){
       return ( f.getPoliseNr() == ( poliseNr) );
       }
    
   
 }// end of abstract class Forsikringer
