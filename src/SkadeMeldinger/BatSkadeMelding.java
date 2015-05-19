/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Klassen skal representere det som er unikt for en båtskademelding, så langt
 * er det bare en toStringmetode, men kan utvides til å inneholde mer.
 * Funksjonen klassen har nå er at man kan bruke polymorfisme til å kjenne den
 * igjen og instansiere.
 *
 * @author Therese
 */
public class BatSkadeMelding extends SkadeMelding implements Serializable {

    public BatSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);
    }

    // teksten som skal vises i vinduet når skademeldingen er registrert.
    public String melding() {

        BatForsikring f = (BatForsikring) super.getForsikring();
        String form = "0.00";
        DecimalFormat tall = new DecimalFormat(form);
        String s;
        s = "Båtskademelding \nInnmeldt av: " + f.getKunde().getFornavn()
                + " " + f.getKunde().getEtternavn() + "\n"
                + super.toString()
                + "\nPremie før skade: " + tall.format(f.getPremie()) + " kr"
                + "\nPremie etter skade: " + tall.format(f.getPremieTilGodkjenning()) + " kr";

        return s;
    }

}
