/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 * Denne klassen representerer båtfosrikringer. Den inneholder data om båtene En
 * båtforsikring inneholder metoder som beregner premie og egenandel , i tillegg
 * et datafelt som øker premien etter et skadetilfelle som har ført til godkjent
 * skademelding. utifra om båten har motor eller ikke.
 *
 * @author Therese, Håkon
 */
public class BatForsikring extends Forsikringer implements Serializable {

    private int lendgeFot, motorStyrke;
    private String regNo, motorMerke, type, modell, årsmodell;
    private double forsikringSum;
    private static final double SKADETILLEGG = 500;
    private static final double  MOTORTILLEGG = 300;
    private static final double DELTAFORSSUM = 0.02;
    
    public BatForsikring(double forSum, int lendgeFot, String regNr, String type, String modell, String arsModell, int motorstyrke, String motormerke) {
        super(0, 0);
        this.lendgeFot = lendgeFot;
        this.forsikringSum = forSum;
        this.type = type;
        this.motorStyrke = motorstyrke;
        this.motorMerke = motormerke;
        this.modell = modell;
        this.årsmodell = arsModell;
        this.regNo = regNr;
    }

    public String getRegNr() {
        return regNo;
    }

    public int getLendgeFot() {
        return lendgeFot;
    }

    public int getMotorStyrke() {
        return motorStyrke;
    }

    public String motorMerke() {
        return motorMerke;
    }

    
    // metoden setter egenandel utifra om båten har motor eller ikke.
    public void beregnOgSetEgenAndel() {
        if (type.equalsIgnoreCase("Motorbåt")) {
            setEgenandel(3000);
        } else {
            setEgenandel(2000);
        }
    }

    // beregner premie utifra forsikringssum
    public void beregnOgSetPremie() {
       
        setPremie(( forsikringSum*DELTAFORSSUM ));

        if ( type.equals( "Motorbåt" ) ) {
           
            double nyPremie = getPremie() + MOTORTILLEGG;
            setPremie( nyPremie );
        }
    }

    // beregner og setter ny premie til godkjenning etter skade.
    public void premieEtterSkade(double gmlPremie) {

        double premieTilGodkjenning = gmlPremie + SKADETILLEGG;
        premieTilGodkjenning(premieTilGodkjenning);
        
    }
    public String toString(){
    String s;
        s = "BilForsikring:";
        s += "\nForsikringen gjelder for reg.nr: " + getRegNr();
        s += "\nMerke: " + type;
        s += "\nModell: " + modell;
        s += "\nÅrsmodell: " + årsmodell;
        s += "\nMotormerke: " + motorMerke;
        s += "\n" + super.toString();
        return s;
    }
    
    
}
