/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese
 */
abstract class Bygg extends Forsikringer implements Serializable {

    protected double kvadrat;
    protected String adresse;
    protected String boligType;
    protected int byggeår;
    protected String materiale;
    protected String standard;
    protected double byggSum;
    protected double innboSum;
    protected double forsikringSum;
    protected boolean utleie;

    public Bygg(boolean utleie, double kvadrat, String adresse, String boligType, int byggeår,
            String materiale, String standard, double byggSum, double inboSum) {
        super(0, 0);
        this.kvadrat = kvadrat;
        this.adresse = adresse;
        this.boligType = boligType;
        this.byggeår = byggeår;
        this.byggSum = byggSum;
        this.innboSum = inboSum;
        this.materiale = materiale;
        this.standard = standard;
        this.utleie = utleie;
        forsikringSum = innboSum + byggSum;
        setPremie(premie(kvadrat, byggSum, innboSum));

    }
    public double getForsikringsSum(){
        return forsikringSum;
    }

    public double getKvadrat() {
        return kvadrat;
    }

    public String adresse() {
        return adresse;
    }

    public String boligType() {
        return boligType;
    }

    public int byggear() {
        return byggeår;
    }

    public double byggSum() {
        return byggSum;
    }

    public double inboSum() {
        return innboSum;
    }

    public String materiale() {
        return materiale;
    }

    public String standard() {
        return standard;
    }

    // beregner egenandelen avhengig av skadetype, og om boligen er fg godkjent.
    public int egenandel(String skadeType, boolean fG) {
        int egenAndel = 4000;
        int fGgodkjent = 4000;

        int brann = 3000;
        int vann = 15000;
        int ror = 25000;

        if (fG) {
            egenAndel -= fGgodkjent;
        }
        switch (skadeType) {
            case "brann":
            case "natur":
                egenAndel += brann;
                break;
            case "vann":
                egenAndel += vann;
                break;
            case "rør":
                egenAndel += ror;
                break;
        }

        return egenAndel;

    }// end of method egenandel

    // utbetaling av erstatningsbeløp, med regler, full utbetaling
    public int utbetaling(double skadeBelop, double verdi, int skadeÅr) {
     
        double totalSkadeGrense = 0.75;
        int femAar = 5;
        int tiAar = 10;

        double delta10 = 0.015;
        double delta5 = 0.01;
        double sum;
        double byggVerdi;

        int alder = skadeÅr - byggeår;

        if (alder >= tiAar) {
            byggVerdi = verdi - alder * verdi * delta10;
        } else if (alder >= femAar) {
            byggVerdi = verdi - alder * verdi * delta5;
        } else {
            byggVerdi = verdi;
        }

        // laveste skadegrense for totalskade her er det tatt hensyn til byggets alder:    
        double minTotal = byggVerdi * totalSkadeGrense;

        // sjekker om bygget er totalskadet, dvs skaden utgjør minst 75% av verdien til boligen.
        if (skadeBelop < minTotal) {
            sum = skadeBelop - egenandel;
        } else {
            sum = byggVerdi - egenandel;
        }

        return (int) sum;

    }// end of method fullUtbetaling  

    // beregner premien utifra størrelsen på boligen og verdien på innboet og bygningen
    public int premie(double kvadrat, double byggSum, double innboSum) {
        double prisPerKvadrat = 0.1;
        double prisPerByggVerdi = 0.0007;
        double prisPerInnbo = 0.003;
        double premium;

        premium = prisPerKvadrat * kvadrat + prisPerByggVerdi * byggSum + prisPerInnbo * innboSum;

        return (int) premium;
    }

}// end of class Bolig.
