/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 * Inneholder datafelter og metoder som er felles for bolig og fritidsbolig.
 * Klassen heter bygg, da det er hovedsakelig bygg metodene baserer seg på. Men
 * lagrer også forsikringssum for innbo. Inneholder metoder som beregner premie,
 * egenandel avhengig av skadetype og premier som følge av at skade er blitt
 * meldt inn
 *
 * @author Therese
 */
abstract class Bygg extends Forsikringer implements Serializable {

    private double forsikringSum;
    private double byggSum;
    private double innboSum;
    private final double PREMIEØKNING = 500;
    private final int GRUNNEGENANDEL = 4000;
    private final int FGGODKJENT = 4000;
    private final int BRANN = 3000;
    private final int VANN = 15000;
    private final int RØR = 25000;
    double TOTALSKADEGRENSE = 0.75;
    double FEMÅR = 5;
    double TIÅR = 10;
    double DELTA10 = 0.015;
    double DELTA5 = 0.01;
    double PRISPERKVADRAT = 0.1;
    double PRISPERBYGGVERDI = 0.0007;
    double PRISPERINNBOVERDI = 0.003;
    private int byggeår;
    private double kvadrat;
    private String adresse;
    private String boligType;
    private String materiale;
    private String standard;
    private boolean utleie;

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

    public double getForsikringsSum() {
        return forsikringSum;
    }

    public double getKvadrat() {
        return kvadrat;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBoligType() {
        return boligType;
    }

    public int getByggeÅr() {
        return byggeår;
    }

    public double getByggSum() {
        return byggSum;
    }

    public double getInnboSum() {
        return innboSum;
    }

    public String getMateriale() {
        return materiale;
    }

    public String getStandard() {
        return standard;
    }
    
    public boolean getUtleie(){
        return utleie;
    }

    // beregner egenandelen avhengig av skadetype, og om boligen er fg godkjent.
    public int egenandel(String skadeType, boolean fG) {
        int egenAndel = GRUNNEGENANDEL;
        if (fG) {
            egenAndel -= FGGODKJENT;
        }
        switch (skadeType) {
            case "BrannSkade":
                egenAndel += BRANN;
                break;
            case "VannSkade":
                egenAndel += VANN;
                break;
            case "RørSkade":
                egenAndel += RØR;
                break;
        }

        return egenAndel;

    }// end of method egenandel

    // utbetaling av erstatningsbeløp, med regler, full utbetaling
    public int utbetaling(double skadeBelop, double verdi, int skadeÅr, int egenandel) {
        double sum;
        double byggVerdi;
        int a = 2015;
        int b = 2010;
        int alder;
        alder = a - b;
        System.out.println("" + alder);
        if (alder >= FEMÅR) {
            byggVerdi = verdi - alder * verdi * DELTA10;
        } else if (alder >= TIÅR) {
            byggVerdi = verdi - alder * verdi * DELTA5;
        } else {
            byggVerdi = verdi;
        }
        System.out.println("byggverdi" + byggVerdi);

        // laveste skadegrense for totalskade her er det tatt hensyn til byggets alder:    
        double minTotal = byggVerdi * TOTALSKADEGRENSE;

        // sjekker om bygget er totalskadet, dvs skaden utgjør minst 75% av verdien til boligen.
        if (skadeBelop < minTotal) {
            sum = skadeBelop - egenandel;
        } else {
            sum = byggVerdi - egenandel;
        }
        System.out.println("Sum" + sum);
        return (int) sum;

    }// end of method fullUtbetaling  

    // beregner premien utifra størrelsen på boligen og verdien på innboet og bygningen
    public int premie(double kvadrat, double byggSum, double innboSum) {

        double premium;
        premium = PRISPERKVADRAT * kvadrat + PRISPERBYGGVERDI * byggSum + PRISPERINNBOVERDI * innboSum;
        return (int) premium;
    }

    // beregner ny premie etter skade.
    public double nyPremie() {
        double nyPremie = getPremie() + PREMIEØKNING;
        return nyPremie;

    }

}// end of class Bolig.
