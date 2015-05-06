/*
 * 
 * 
 */
package Forsikring;

import Person.Person;
import java.io.Serializable;

/**
  Denne klassen representerer bilforsikringer,og inneholder data om bilen, og hvorvidt det er en annen person registrert som eier, enn kunden.
 * den beregner premien utifra egenandel og bonus. 
 * Den inneholder også metoder som setter ned bonusen etter skade og øker premien.
 * I tillegg inneholder den metoder som beregner utbetaling ved skadetilfelle.
 * @author Therese, Håkon
 */
public class BilForsikring extends Kjoretoy implements Serializable {

    private int kjorelengde;
    private int kmStand;
    private double bonusTilGodkjenning;
    private Person person;

    //(bonus, egenandel, kjøreLengde, regNo, bilMerke, bilModell, årsModell, kmStand);

    public BilForsikring(double bonus, double egenandel, int kjorelengde, String regNr, String type, String bilModell, String arsModell, int kmStand) {
        super(bonus, egenandel, regNr, type, bilModell, arsModell);
        this.kjorelengde = kjorelengde;
        this.kmStand = kmStand;
        premie = (premie(egenandel, bonus));// premien settes
    }
    
    /* legger på peker på et nytt personobjekt, i tilfelle det er 
        en annen person som er registert som eier av bilen*/
    public void setPerson(Person p){
        person = p;
    }

    public int getKjorelengde() {
        return kjorelengde;
    }

    // har pris per kilometer
    public int utbetal(int km, double kostnad) {
        double delta = 0; // angir hvor stor andel av skaden som dekkes
        double belop;
        double utbetales = 0;

        if (km > 350000) {
            delta = 0.2;
        } else if (km > 300000 && km <= 350000) {
            delta = 0.3;
        } else if (km > 200000 && km <= 300000) {
            delta = 0.4;
        } else if (km > 150000 && km <= 200000) {
            delta = 0.6;
        } else if (km > 100000 && km <= 150000) {
            delta = 0.8;
        } else if (km <= 100000) {
            delta = 0;
        }

        if (delta != 0) {
            belop = delta * kostnad;
        } else {
            belop = kostnad;
        }
        if (belop > egenandel) {
            utbetales = belop;
        }

        return (int) utbetales;

    }// end of method utbetal

    
    //lagrer ny bonus etter skade, i påvente av at skaden skal bli behandlet
    public void nyBonusTilGodkjenning(double bonusEtterSkade) {
        bonusTilGodkjenning = bonusEtterSkade;
    }

    //Setter den nye bonusen når konsulenten har behandlet skaden
    public void bonusGodkjent() {
        bonus = bonusTilGodkjenning;
    }

    // beregner bonusen etter skaden. parameteren angir hva bonusen var før skaden
    public double bonusEtterSkade(double bonus) {
        if (bonus == 0) {
            bonus -= 40;
        }
        if (bonus >= 10 && bonus <= 60) {
            bonus -= 30;
        }
        if (bonus == 70) {
            bonus -= 30;
        }
        if (bonus == 75) {
            bonus -= 15;
        }
        return bonus;
    }// end of method

    // beregner premien basert på bonus etter en skade.
    public double premieEtterSkade(double grunnPremie, double nyBonus) {
        double nyPremie = (100 - nyBonus) / 100 * grunnPremie;
        return nyPremie;
    }// end of method

    // bestemmer premien utifra hva som velges som egenandel. 
    public double premie(double egenandel, double bonus) {
        double grunnPremie = 20000;
        double premium;
        double rabatt = 0;

        if (egenandel == 10000) {
            rabatt = 15;
        } else if (egenandel == 6000) {
            rabatt = 10;
        } else if (egenandel == 4000) {
            rabatt = 0;
        }

        premium = (100 - rabatt - bonus) / 100 * grunnPremie;

        return premium;
    }// end of method premie

    public String toString() {
        String s;
        s = "BilForsikring:" + "\nForsikringen gjelder for reg.nr: " + regNr 
                + "\nPoliseNr: " + poliseNr
                + "Gjelder fra: " + startDato + "\ttil: " + utløpsDato
                + "\nMerke: " + modell + "\tÅrsmodell: " + arsModell
                +"\n";
        return s;
    }// end of toString()

}// end of class BilForsikring.
