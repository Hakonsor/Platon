/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Therese, Håkon
 */
public abstract class SkadeMelding implements Serializable {

    public static int getStaticSkadeNr() {
        return nesteSkadeNr;
    }

    public static void setStaticSkadeNr(int nyttSkadeNr) {
        nesteSkadeNr = nyttSkadeNr;
    }
    private String skadeBeskrivelse;
    private Calendar skadeDato;  // når skaden inntraff.
    private Calendar datoInnmeldt;
    private Object skadeBilde;
    private int skadeSum;
    private Forsikringer forsikring;
    // private String forsikringstype;
    private static int nesteSkadeNr = 100000;
    private int skadeNr;
    private double utbetaling;
    private boolean godkjent;

    private SkadeMelding() {
        skadeNr = (++nesteSkadeNr);
    }

    // mottar skadebeløpet, mens utbetalingen settes av konsulenten
    public SkadeMelding(String skadeBeskrivelse, int skadeSum, Calendar skadeDato) {
        this();
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.skadeSum = skadeSum;
        datoInnmeldt = Calendar.getInstance();
        this.skadeDato = skadeDato;
    }

    public void setUtbetaling(double utbetaling) {
        this.utbetaling = utbetaling;
    }

    public double getUtbetaling() {
        return this.utbetaling;
    }

    // viser at skademeldingen er godkjent.

    public void okUtbetal() {
        godkjent = true;
    }

    public boolean godkjent() {
        return godkjent;
    }

    public void avvis() {
        utbetaling = 0;
    }

    public String getSkadeBeskrivelse() {
        return skadeBeskrivelse;
    }

    public Calendar getdatoInnmeldt() {
        return datoInnmeldt;
    }

    public void setDatoSkade(Calendar skadeDato) {
        this.skadeDato = skadeDato;
    }

    public int getSkadeNr() {
        return skadeNr;
    }

    public Forsikringer getForsikring() {
        return forsikring;
    }

    public void setForsikring(Forsikringer forsikring) {
        this.forsikring = forsikring;
    }

    public Object getSkadeBilde() {
        return skadeBilde;
    }

    public void setSkadeBilde(Object skadeBilde) {
        this.skadeBilde = skadeBilde;
    }

    public int getskadeNr() {
        return skadeNr;
    }

    public String toString() {
        Date dt = skadeDato.getTime();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dato = df.format(dt);
        
        String form = "0.00";
                DecimalFormat tall = new DecimalFormat(form);
        String s = "Skadedato: "
                + dato + "\tSkadeNr: " + skadeNr + "\nSkadebeløp: "
                + tall.format(skadeSum) + " kr\t Utbetaling: " + tall.format(utbetaling) + " kr\nSkadebeskrivelse: \n"
                + skadeBeskrivelse;
        return s;
    }
}
