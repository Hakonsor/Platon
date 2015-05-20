/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 * Inneholder en svært enkel mal for reiseforsikring, der premien og egenandelen settes
 * på svært enkle grunnlag. men kan utvides ved at den forgreines og blir mer spsifikk.
 *
 * @author Therese, Håkon
 */
public class ReiseForsikring extends Forsikringer implements Serializable {

    private String type;
    private double forsikringSum;
    private static final int VERDENPREMIE = 1700;
    private static final int EUROPAPREMIE = 1400;
    private static final int NORDENPREMIE = 900;
    
    private static final int VERDENFORSUM =  10000000;
    private static final int EUROPAFORSUM = 1000000;
    private static final int NORDENFORSUM = 1000000;
    private static final int ØKNINGPREMIE =200;
    public ReiseForsikring() {
        super(0, 0);

    }

    public String getType() {
        return type;
    }

    // Premien setter avhangig av om det er verden, europa eller norden

    public void setType(String type) {
        this.type = type;
    }
    
    // setter premie og forsikringsum
    public void setPremieOgForsSum(String type) {
        if (type.equals("Verden")) {
            setPremie(VERDENPREMIE);
            forsikringSum =VERDENFORSUM; 
        } else if (type.equalsIgnoreCase("Europa")) {
            setPremie(EUROPAPREMIE);
            forsikringSum = EUROPAFORSUM; 
        } else if (type.equalsIgnoreCase("Norden")) {
            setPremie(NORDENPREMIE);
            forsikringSum = NORDENFORSUM;
        }
    }

    
    public void premieTilGodkjenning() {
        double premieøkning = ØKNINGPREMIE;
        premieTilGodkjenning(getPremie() +premieøkning);
    }

    public String toString() {
        String s;
        s = "ReiseForsikring:";
        s += "\nForsikringen gjelder for: " + type;
        s += "\nPoliseNr: " + getPoliseNr();
        s += "\n" + super.toString();
        s += "\nForsikringsum: " + forsikringSum;
        return s;
    }

}// end of class ForsikringsPremie.
