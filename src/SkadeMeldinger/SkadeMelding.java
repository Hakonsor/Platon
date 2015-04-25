/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Therese, Håkon
 */
public abstract class SkadeMelding implements Serializable {
    private String skadeBeskrivelse;
    private Calendar datoSkade;  // når skaden inntraff.
    private Calendar datoInnmeldt;
    private Object skadeBilde;
    private int skadeSum;
    private int utbetal;
    private Forsikringer forsikring;
    private String forsikringstype;
    private static int nesteSkadeNr = 100000;
    private int skadeNr;
   
    
    // tom konstruktør for å opprette objektet i fabrikk
    public SkadeMelding(){
       datoInnmeldt = Calendar.getInstance();
    }
   // private SkadeMelding(){
        
    //skadeNr = (++nesteSkadeNr);
   // } 
    
    // mottar skadebeløpet, mens utbetalingen settes av konsulenten
    public SkadeMelding(String skadeBeskrivelse , int skadeSum){
        this(); 
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.skadeSum = skadeSum;
        datoInnmeldt = Calendar.getInstance();
    }
   
    
   // utbetalingen settes av konsulenten.
    public void setUtbetal( int utbetaling){
        this.utbetal = utbetaling;
    }
 
   public int getUtbetalingsSum(){
        return utbetal;
   }
   
  
  public String getSkadeBeskrivelse(){ 
        return skadeBeskrivelse;
    }
    
    public Calendar getdatoSkade(){
        return datoSkade;
    }
    
    public void setDatoSkade(Calendar skadeDato){
        this.datoSkade = skadeDato;
    }
    public int getSkadeNr(){
        return skadeNr;
    }
    public Forsikringer getForsikring(){
        return forsikring;
    }
    public void setForsikring(Forsikringer forsikring){
        this.forsikring = forsikring;
    }
    public String getforsikringsType(){
        return forsikringstype;
    }
    public Object getSkadeBilde(){
        return skadeBilde;
    }
    public void setSkadeBilde(Object skadeBilde){
        this.skadeBilde = skadeBilde;
    }
    public int getForsikringsSum(){
        return utbetal;
    }
    public int getskadeNr(){
        return skadeNr;
    }
}
