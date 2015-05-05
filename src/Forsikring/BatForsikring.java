/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;


import java.io.Serializable;

/** Denne klassen representerer båtfosrikringer. Den inneholder data om båtene 
 * En båtforsikring inneholder metoder som beregner premie og egenandel , i tillegg et datafelt som 
 * øker premien etter et skadetilfelle som har ført til godkjent skademelding.
 * utifra om båten har motor eller ikke.
 * @author Therese, Håkon
 */
public class BatForsikring extends Forsikringer implements Serializable{
    
    private int lendgeFot, motorStyrke;
    private String regNo, motorMerke, type;
    private double forsikringSum;
    
    public BatForsikring(double forSum, int lendgeFot,String regNr , String type, String modell, String arsModell){
    super(0, 0); 
    this.lendgeFot = lendgeFot;
    this.forsikringSum = forSum;
    this.type = type;
    }
    
    public String getRegNr(){
        return regNo;
    }
    public int getLendgeFot(){
     return lendgeFot;
    }
    public int getMotorStyrke(){
     return motorStyrke;
    }
    public String motorMerke(){
     return motorMerke;
    }
    
    public String toString(){
        return "s";
    }
    
    // metoden setter egenandel utifra om båten har motor eller ikke.
    public void beregnEgenAndel(){
        if(type.equals("Motorbåt")){
           egenandel = 3000;
        }
        else{
            egenandel= 2000;
        } 
    }
    
    // beregner premie utifra forsikringssum
    public void beregnPremie(){
        double deltaForsSum = 0.02;
        premie =( forsikringSum*deltaForsSum);
        
        if(type.equals("Motorbåt")){
            double motorTillegg = 300;
            premie += motorTillegg;
        }
    }
    
    // beregner ny premie etter skade
    public void premieEtterSkade(double gmlPremie){
        double tillegg = 500;
        premieTilGodkjenning = gmlPremie + tillegg;  
    }
}
