/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

import java.util.Calendar;

/**
 *
 * @author Therese, Håkon
 */
public abstract class SkadeMelding {
    private String skadeBeskrivelse;
    private Calendar datoSkade;  // når skaden inntraff.
    private Calendar datoSkadeRegistert;
    private int skadeNr;
    private int erstatt;// beløpet skaden påløper
    private Forsikringer forsikring;// usikker om vi skal legge inn forsikring eller forsikringstype
    private String forsikringsType;
    private static int nesteSkadeNr = 100000;
    private Object skadeBilde; 
    
    private SkadeMelding(){
    skadeNr = (++nesteSkadeNr);
    } 
    
    public SkadeMelding(String skadeBeskrivelse , int erstatt , Forsikringer forsikring){
    this(); 
    this.skadeBeskrivelse = skadeBeskrivelse;
    this.erstatt = erstatt;
    this.forsikring = forsikring;
    datoSkadeRegistert = Calendar.getInstance();
    }
    
    public String getSkadeBeskrivelse(){
        return skadeBeskrivelse;
    }
    public Calendar getDatoSkadeRegistert(){
        return datoSkadeRegistert;
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
    public int getErstatt(){
        return erstatt;
    }
    public void setErsatt( int erstattingSum){
        this.erstatt = erstattingSum;
    }
    public Forsikringer getForsikring(){
        return forsikring;
    }
    public void setForsikring(Forsikringer forsikring){
        this.forsikring = forsikring;
    }
    public String getforsikringsType(){
        return forsikringsType;
    }
    public Object getSkadeBilde(){
        return skadeBilde;
    }
    public void setSkadeBilde(Object skadeBilde){
        this.skadeBilde = skadeBilde;
    }
    public int getForsikringsSum(){
        return erstatt;
    }
    public int getskadeNr(){
        return skadeNr;
    }
}
