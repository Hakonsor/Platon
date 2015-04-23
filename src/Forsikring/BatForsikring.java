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
    
    public BatForsikring( double bonus, String motorType, int lendgeFot, int motorStyrke, int premie , int egenandel, int tlf , String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr, String regNr , String type, String arsModell){
    super( bonus, tlf , fornavn,  etternavn,  personNr, gateAdr, gateNr, postNr, regNr , type , arsModell); 
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
