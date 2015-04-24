/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class BatForsikring extends Kjoretoy implements Serializable{
    
    private int lendgeFot, motorStyrke;
    private String motorType;
    
    public BatForsikring( double bonus, String motorType, int lendgeFot, int motorStyrke,
            String regNr , String type,String modell, String arsModell){
        
    super( bonus, regNr ,type,modell,arsModell); 
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
}
