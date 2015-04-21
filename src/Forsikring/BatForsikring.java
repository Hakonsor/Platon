/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

/**
 *
 * @author Therese, Håkon
 */
public class BatForsikring extends Kjoretoy{
    private int lendgeFot, motorStyrke;
    private String motorType;
    
    public BatForsikring( String motorType, int lendgeFot, int motorStyrke, int premie , int egenandel, int tlf , String forsikrBet, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr, String regNr , String type , String modell ,String arsModell){
    super(premie ,  egenandel,  tlf , forsikrBet, fornavn,  etternavn,  personNr, gateAdr, gateNr, postNr, regNr , type , modell , arsModell); 
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
