/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;
import Person.Kunde;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**Inneholder datafelter og metoder som er felles for alle forsikringene. 
 * Og er øverste klasse(abstract) i hierarkiet av forsikringer.
 *
 * 
 *
 * @author Therese, Håkon
 */
public abstract class Forsikringer implements Serializable{
    private boolean aktiv;
    private Kunde kunde;
    private int poliseNr;
    private static int nestePoliseNr = 100000;
    private double premie;
    private double premieTilGodkjenning;
    private double egenandel;
    private Calendar startDato;
    private Calendar utløpsDato;

     
    
    private Forsikringer() {
        poliseNr = ++nestePoliseNr;
        aktiv =true; 
        
    }
    // brukes når det registreres kjøretøy.
    public Forsikringer( double premie, double egenandel ){
       this();
       this.premie = premie;
       this.egenandel = egenandel;
       aktiv = true;
       startDato = Calendar.getInstance();
       utløpsDato = new GregorianCalendar(startDato.get(Calendar.YEAR)+ 1, startDato.get(Calendar.MONTH), startDato.get(Calendar.MONTH));
    }
    public void setGenerertDato(GregorianCalendar gc){
    startDato = gc;
    }
    public static int getStaticPolisenr(){
        return nestePoliseNr;
    }
    
    public static void setStaticPolisenr(int nyNesteNr){
        nestePoliseNr = nyNesteNr;
    }
    
    // mottar en premie som skal bli den nye premien når skaden er godkjent
    public void  premieTilGodkjenning(double nyPremie){
        premieTilGodkjenning = nyPremie;  
    }
    
    // Når skademeldingen bekreftet ok, så settes premien på nytt.(Økning) 
    public void nyPremieOk(){
        premie = premieTilGodkjenning;
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
    
    public void setEgenandel(double egenandel){
        this.egenandel = egenandel;
    }
    
    public void setStartDato( Calendar startDato ){
       this.startDato = startDato;
       
    }
   
    public void setSluttDato( Calendar sluttDato ){
       this.utløpsDato = sluttDato;
       
    }
   
   
    public Calendar getStartDato(){
       return startDato;
   }
   
    
    public Calendar getSluttDato(){
       return utløpsDato;
   } 
    
    public String toString(){
       Date dt = startDato.getTime();
       DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
       String dato = df.format(dt);
       
       Date da = utløpsDato.getTime();
       DateFormat datf = new SimpleDateFormat("dd.MM.yyyy"); 
       String date = datf.format(da);
       
        String s = "Polisenummer: " + poliseNr + "\nPremie: "
        + premie + "\nEgenandel: " + egenandel  +
        "\nGjelder fra: " +  dato +" Utløper: " + date;
            return s;
    }
    
    // metoden sammenligner på poliseNr for å avgjøre om de er like
    public boolean equals(Forsikringer f){
       return ( f.getPoliseNr() == ( poliseNr) );
       }

    public void setInaktiv() {
        aktiv = false;
    }
    public boolean getAktiv() {
        return aktiv;
    }
    
   
 }// end of abstract class Forsikringer
