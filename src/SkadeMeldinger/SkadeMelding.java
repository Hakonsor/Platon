/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Therese, Håkon
 */
public abstract class SkadeMelding implements Serializable {
    protected String skadeBeskrivelse;
    protected Calendar skadeDato;  // når skaden inntraff.
    protected Calendar datoInnmeldt;
    protected Object skadeBilde;
    protected int skadeSum;
    protected Forsikringer forsikring;
   // private String forsikringstype;
    protected static int nesteSkadeNr = 100000;
    protected int skadeNr;
    protected int utbetaling;
    private boolean godkjent;
    
    
   private SkadeMelding(){
       skadeNr = (++nesteSkadeNr);
   } 
    
    // mottar skadebeløpet, mens utbetalingen settes av konsulenten
    public SkadeMelding(String skadeBeskrivelse , int skadeSum, Calendar skadeDato){
        this(); 
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.skadeSum = skadeSum;
        datoInnmeldt = Calendar.getInstance();
        this.skadeDato = skadeDato; 
    }
    
    
    public void setUtbetaling(int utbetaling){
        this.utbetaling = utbetaling;
    }
    // viser at skademeldingen er godkjent.
    public void okUtbetal(){
        godkjent = true;
    }
    public void avvis(){
        utbetaling = 0;
    }
    
    // henter summen av alle innbetalinger 
   
     public String getSkadeBeskrivelse(){ 
        return skadeBeskrivelse;
    }
    
    public Calendar getdatoSkade(){
        return skadeDato;
    }
    
    public void setDatoSkade(Calendar skadeDato){
        this.skadeDato = skadeDato;
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
    
    public Object getSkadeBilde(){
        return skadeBilde;
    }
    public void setSkadeBilde(Object skadeBilde){
        this.skadeBilde = skadeBilde;
    }
   
    public int getskadeNr(){
        return skadeNr;
    }
    
    public String toString(){
       Date dt = skadeDato.getTime();
       DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
       String dato = df.format(dt);
       String s = "Skadedato: " 
                + dato + "\tSkadeNr: " + skadeNr + "\nForsikringsum: " + forsikring.getForsikringssum() +"\nSkadebeløp: "
                + skadeSum + "\t\t Utbetaling: " + utbetaling + "\nSkadebeskrivelse: \n" 
                + skadeBeskrivelse;
        return s;
    }
}
