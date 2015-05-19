/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.BoligForsikring;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Inneholder det som er unikt for boligskademelding, foreløpig er deet bare en
 * melding
 *
 * @author Therese
 */
public class BoligSkadeMelding extends ByggSkade implements Serializable {

    public BoligSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);

    }

    // denne meldingen vises i vinduet for skadebehandleren
    public String melding() {
        BoligForsikring f = (BoligForsikring) super.getForsikring();
        String form = "0.00";
        DecimalFormat tall = new DecimalFormat(form);
        String s;
        s = "Boligskademelding \nInnmeldt av: " + f.getKunde().getFornavn() + " " + f.getKunde().getEtternavn() + "\n"
                + super.toString()
                + "\nPremie før skade: " + tall.format(f.getPremie()) + " kr"
                + "\nPremie etter skade: " + tall.format(f.getPremieTilGodkjenning()) + " kr";

        return s;
    }

}
