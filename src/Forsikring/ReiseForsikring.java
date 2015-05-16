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
    private final int VERDEN = 1700;
    private final int EUROPA = 1400;
    private final int NORDEN = 900;
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
            setPremie(VERDEN);
            forsikringSum = 10000000; 
        } else if (type.equalsIgnoreCase("Europa")) {
            setPremie(EUROPA);
            forsikringSum = 1000000; 
        } else if (type.equalsIgnoreCase("Norden")) {
            setPremie(NORDEN);
            forsikringSum = 1000000;
        }
    }

    
    public void premieTilGodkjenning() {
        double premieøkning = 200;
        premieTilGodkjenning(getPremie() +premieøkning);
    }

    public String toString() {
        String s;
        s = "ReiseForsikring:" + "\nForsikringen gjelder for: " + type
                + "PoliseNr: " + getPoliseNr()
                + "Gjelder fra: " + getStartDato() + "\ttil: " + getSluttDato()
                + "Forsikringsum: " + forsikringSum;
        return s;
    }

}// end of class ForsikringsPremie.
