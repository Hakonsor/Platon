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
public class ReiseForsikring extends Forsikringer implements Serializable {

    private String type;

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

    public void setPremie(String type) {
        if (type.equals("Verden")) {
            premie = 1700;
        } else if (type.equalsIgnoreCase("Europa")) {
            premie = 1400;
        } else if (type.equalsIgnoreCase("Europa")) {
            premie = 900;
        }
    }

    public double egenAndel() {
        egenandel = 300;
        return egenandel;
    }

    public void premieTilGodkjenning() {
        int tillegg = 200;
        premieTilGodkjenning = premie +tillegg;
    }

    public String toString() {
        String s;
        s = "ReiseForsikring:" + "\nForsikringen gjelder for: " + type
                + "PoliseNr: " + poliseNr
                + "Gjelder fra: " + startDato + " til:  sluttDato"
                + "Forsikringsum: " + forsikringSum;
        return s;
    }

}// end of class ForsikringsPremie.
