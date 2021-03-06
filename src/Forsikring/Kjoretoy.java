/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import Person.Person;
import java.io.Serializable;

/**
 *Inneholder alt det som er likt for kjøretøy, og er superklassen til bil. 
 * @author Therese, Håkon
 */
public abstract class Kjoretoy extends Forsikringer implements Serializable{
    private String regNr , type , modell , arsModell;
    private double bonus;
    private Person person;
    
    public Kjoretoy( double bonus, double egenandel,String regNr , String type, String modell, String arsModell ){
        super(0,egenandel);
        this.bonus= bonus;
        this.regNr = regNr;
        this.type = type;
        this.modell = modell;
        this.arsModell = arsModell;
        
     
    }
    
    public void setPerson(Person person ){
        this.person = person;
        
    }
    public String getRegNr(){
     return regNr;
    }
    
    public String getType(){
     return type;
    }
    public String getModell(){
     return modell;
    }
    public String getArsModell(){
     return arsModell;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public double getBonus(){
     return bonus;
    }
    
    public String toString(){
        
      return super.toString();
    }   
}// end of class Kjoretoy
