/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import Forsikring.ReiseForsikring;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Inneholder det som er unikt for reiseskademeldinger, foreløpig bare en
 * toString().
 *
 * @author Therese
 */
public class ReiseSkadeMelding extends SkadeMelding {

    public ReiseSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);

    }

    public String melding() {
        String form = "0.00";
        DecimalFormat tall = new DecimalFormat(form);
        String s;
        ReiseForsikring f = (ReiseForsikring) super.getForsikring();
        s = "Reiseskademelding \nInnmeldt av: " + f.getKunde().getFornavn() + " " + f.getKunde().getEtternavn() + "\n"
                + "Forsikringstype: " + f.getType() + "\n"
                + super.toString()
                + "\nPremie før skade: " + tall.format(f.getPremie()) + " kr"
                + "\nPremie etter skade: " + tall.format(f.getPremieTilGodkjenning()) + " kr";

        return s;
    }

}
