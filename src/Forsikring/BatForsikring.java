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
    private String regNo, motorMerke, type;
    private double forsikringSum;
    private final double SKADETILLEGG = 500;
    private final double  MOTORTILLEGG = 300;
    private final double DELTAFORSSUM = 0.02;
    
    public BatForsikring(double forSum, int lendgeFot, String regNr, String type, String modell, String arsModell, int motorstyrke, String motormerke) {
        super(0, 0);
        this.lendgeFot = lendgeFot;
        this.forsikringSum = forSum;
        this.type = type;
        this.motorStyrke = motorstyrke;
        this.motorMerke = motormerke;
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

    public String toString() {
        return "s";
    }

    // metoden setter egenandel utifra om båten har motor eller ikke.
    public void beregnOgSetEgenAndel() {
        if (type.equals("Motorbåt")) {
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
    
    
}
