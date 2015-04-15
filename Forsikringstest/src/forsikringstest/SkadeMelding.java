/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

import java.util.Calendar;

/**
 *
 * @author Therese
 */
public abstract class SkadeMelding {
    String skadeBeskrivelse;
    Calendar datoSkade;  // når skaden inntraff.
    int skadeNr;
    int erstatt;// beløpet skaden påløper
    Forsikringer forsikring;// usikker om vi skal legge inn forsikring eller forsikringstype
    String forsikringsType;
    private static int nesteSkadeNr = 100000;
    Object skadeBilde; 
    
    private SkadeMelding(){
    skadeNr = (++nesteSkadeNr);
    } 
    
    public SkadeMelding(String skadeBeskrivelse , int erstatt , Forsikring forsikring)
    this();
    
    public int getForsikringsSum(){
        return erstatt;
    }
    
    public int getskadeNr(){
        return skadeNr;
    }
    
    public Calendar getDato(){
        return datoSkade;
    }
    
}
