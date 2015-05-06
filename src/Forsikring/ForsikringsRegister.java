/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import Person.Kunde;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *Inneholder alle forsikringer, og metoder som kan hente ut informasjon om forsikringsobjekene.
 * som premier, og forsikringsnummer og hvem forsikringen tilhører
 * @author Therese
 */
public class ForsikringsRegister implements Serializable {

    private List<Forsikringer> register;

    public ForsikringsRegister() {
        register = new ArrayList();
    }

    // legger til et objekt i listen, og registrerer hvilken kuned den tilhører
    public void settInn(Kunde k, Forsikringer f) {
        f.setKunde(k);
        register.add(f);
    }

    // finner summen av alle premieinntekter iløpet av et år
     public double finnInntekterAlleFors(int år) {
       double sum = 0;
       sum = register.stream().map((f) -> f.getPremie()).reduce(sum, (accumulator, item) -> accumulator + item);
        return sum; 
    }
    
     
    // finner summen av alle inntektene på boligforsikring iløpet av et år
    public double finnInntekterBoligForsikring(int år) {
        
        double sum = 0;
        sum = register.stream().filter((f) -> (f instanceof BoligForsikring && f.getStartDato().get(Calendar.YEAR ) == år))
                .map((f) -> f.getPremie()).reduce(sum, (accumulator,item) -> accumulator + item);
        return sum;
        
    }
    // finner summen av alle inntekter på fritidsbolig i løpet av et år
    public double finnInntekterFritidsBolig(int år) {
        
       double sum = 0;
        sum = register.stream().filter((f) -> (f instanceof FritidsBolig)&& f.getStartDato().get(Calendar.YEAR ) == år)
                .map((f) -> f.getPremie()).reduce(sum, (accumulator,item) -> accumulator + item);
        return sum; 
        
    }
    
    // finner summen av alle inntekter på bil i løpet av et år
    public double finnInntekterBil(int år) {
        
       double sum = 0;
        sum = register.stream().filter((f) -> (f instanceof BilForsikring)&& f.getStartDato().get(Calendar.YEAR ) == år)
                .map((f) -> f.getPremie()).reduce(sum, (accumulator,item) -> accumulator + item);
        return sum; 
        
    }
    
    // finner summen av alle inntekter på bil i løpet av et år
    public double finnInntekterBåt(int år) {
        
       double sum = 0;
        sum = register.stream().filter((f) -> (f instanceof BatForsikring)&& f.getStartDato().get(Calendar.YEAR ) == år)
                .map((f) -> f.getPremie()).reduce(sum, (accumulator,item) -> accumulator + item);
        return sum; 
        
    }
    
    // finner summen av alle inntekter på reiseforsikring iløpet av et år
    public double finnInntekterReiseFors(int år) {
       double sum = 0;
        sum = register.stream().filter((f) -> (f instanceof ReiseForsikring)&& f.getStartDato().get(Calendar.YEAR ) == år)
                .map((f) -> f.getPremie()).reduce(sum, (accumulator,item) -> accumulator + item);
        return sum; 
    }
    
    

    // metoden returnerer en liste med forsikringer til en bestemt kunde. 
    // avhengig av valg: av en type eller av alle typer.
    public List finnForsikring(Kunde kunde, int forsType) {

        List<Forsikringer> liste = new ArrayList<>();
        if (forsType == 0) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr())).forEach((f) -> {
                liste.add(f);
            });
        } else if (forsType == 1) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof BatForsikring)).forEach((f) -> {
                liste.add(f);
            });
        } else if (forsType == 2) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof ReiseForsikring)).forEach((f) -> {
                liste.add(f);
            });
        } else if (forsType == 3) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof BilForsikring)).forEach((f) -> {
                liste.add(f);
            });
        } else if (forsType == 4) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof BoligForsikring)).forEach((f) -> {
                liste.add(f);
            });
        } else if (forsType == 5) {
            register.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof FritidsBolig)).forEach((f) -> {
                liste.add(f);
            });
        }
        return liste;
    }// end of method  finnForsKunde

    // henter ut alle forsikringene som er kjøpt et gitt år
    public List finnForsikringer(Calendar c) {
        List<Forsikringer> liste = new ArrayList<>();
        register.stream().filter((f) -> (f.getStartDato().get(Calendar.YEAR) == c.get(Calendar.YEAR))).forEach((f) -> {
            liste.add(f);
        });
        return liste;

    }// end of method finnAntallForsikringer

    public int genererPolisenr() {
        int nr = 1000;
        if (register.isEmpty()) {
            return nr;
        } else {
            for (Forsikringer forsikring : register) {
                if (forsikring.getPoliseNr() == nr) {
                    nr++;
                }
            }
        }
        return nr;

    }

    // finner en forsikring gitt polisenr
    public Forsikringer finnForsPolise(int poliseNr) {
        Iterator<Forsikringer> i = register.iterator();
        while (i.hasNext()) {
            Forsikringer f = i.next();
            if (f.getPoliseNr() == poliseNr) {
                return f;
            }
        }
        return null;
    }// end of method finnForsPolise

    public void fjernForsikring(int poliseNr) {
        finnForsPolise(poliseNr).setInaktiv();
        System.out.println(finnForsPolise(poliseNr).aktiv);
    }

}// end of class ForsikringsRegister

