/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.FritidsBolig;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Klassen inneholder det som er unikt for fritidsboligskademelding, nå er det
 * bare en melding.
 *
 * @author Therese
 */
public class FritidsBoligMelding extends ByggSkade implements Serializable {

    public FritidsBoligMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);

    }

    // melding som vises i vinduet når skadebehandleren behandler skader.
    public String melding() {
        FritidsBolig f = (FritidsBolig) super.getForsikring();
        String form = "0.00";
        DecimalFormat tall = new DecimalFormat(form);
        String s;
        s = "Fritidshus skademelding \nInnmeldt av: " + super.getForsikring().getKunde().getFornavn() + " " + super.getForsikring().getKunde().getEtternavn() + "\n"
                + super.toString()
                + "\nPremie før skade: " + tall.format(f.getPremie()) + " kr"
                + "\nPremie etter skade: " + tall.format(f.getPremieTilGodkjenning()) + " kr";
        return s;
    }

}
