/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import Person.Person;
import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class BatForsikring extends Kjoretoy implements Serializable{
    
    private int lendgeFot, motorStyrke;
    private String motorType;
    
    public BatForsikring( double bonus,double egenandel, String motorType, int lendgeFot, int motorStyrke,String regNr , String type, String modell, String arsModell, Person person){
    super( bonus,egenandel, regNr ,type,modell,arsModell, person); 
    this.lendgeFot = lendgeFot;
    this.motorStyrke = motorStyrke;
    this.motorType = motorType;
    }
    
    public int getLendgeFot(){
     return lendgeFot;
    }
    public int getMotorStyrke(){
     return motorStyrke;
    }
    public String getMotorType(){
     return motorType;
    }
    
    public String toString(){
        return "s LALALALALALLA";
    }
}
