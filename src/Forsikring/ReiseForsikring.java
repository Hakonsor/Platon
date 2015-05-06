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
            premie = 1700;
            forsikringSum = 10000000; 
        } else if (type.equalsIgnoreCase("Europa")) {
            premie = 1400;
            forsikringSum = 1000000; 
        } else if (type.equalsIgnoreCase("Europa")) {
            premie = 900;
            forsikringSum = 1000000;
        }
    }

    
    public void premieTilGodkjenning() {
        int premieøkning = 200;
        premieTilGodkjenning = premie +premieøkning;
    }

    public String toString() {
        String s;
        s = "ReiseForsikring:" + "\nForsikringen gjelder for: " + type
                + "\nPoliseNr: " + poliseNr
                + "\nGjelder fra: " + startDato + "\ttil: " + utløpsDato
                + "\nForsikringsum: " + forsikringSum;
        return s;
    }

}// end of class ForsikringsPremie.
