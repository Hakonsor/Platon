/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Person.Bruker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * I denne klassen settes skademeldingene først i kø, 
 * når de er behandlet av skadebehandler, så legges de i registeret. I registeret 
 * legges både godkjente og avviste skademeldinger.
 * 
 * Her er det også metoder som henter ut informasjon om skademeldingene til bruk 
 * ved å beregne statistikk, utgifter
 *
 * @author Therese
 * @author Håkon
 *
 */
public class SkadeMeldingRegister implements Serializable {

    private int index;

    LinkedList<SkadeMelding> behandling;
    List<SkadeMelding> register;

    public SkadeMeldingRegister() {
        behandling = new LinkedList<>();
        register = new ArrayList<>();
    }

    // legger skademeldingen i behandlingskøen, og knytter en forsikring til skademeldingen.
    public void leggIKø(SkadeMelding skade) {
        behandling.add(skade);
    }//end method

    // returnerer det første objektet i listen, hvis det ikke finnes 
    public SkadeMelding getFørste() {
        if (!behandling.isEmpty()) {
            return behandling.getFirst();
        }
        return null;
    }

    // returnerer antall ubehandlede skader
    public int visAntallIKø() {
        return behandling.size();
    }

    public int visIndex() {
        if (behandling.isEmpty()) {
            return 0;
        } else {
            int visIndex = index + 1;
            return visIndex;
        }
    }

    // henter ut neste i køen
    public SkadeMelding visNesteIKø() {
        index++;
        if (index < behandling.size()) {
            SkadeMelding skade = behandling.get(index);
            return skade;
        } else {
            index = 0;
            return getFørste();

        }
    }

    // bruker indexen til å finne forrige elementet i listen
    public SkadeMelding visForrigeIKø() {

        if (index == 0) {
            index = behandling.size() - 1;
            if (!behandling.isEmpty()) {
                return behandling.getLast();
            } else {
                return null;
            }
        }
        index--;
        if (!behandling.isEmpty()) {
            return behandling.get(index);
        } else {
            return null;
        }
    }

    // flytter objekt fra behandling til registeret
    public void flyttTilRegister(SkadeMelding skade) {
        register.add(skade);
        boolean remove = behandling.remove(skade);

    }
    public List<SkadeMelding> finnGodkjentListe(int år){
        List<SkadeMelding> list = new LinkedList<>();
        register.stream().filter((s) -> (s.godkjent() && s.getdatoInnmeldt().get(Calendar.YEAR) == år)).forEach((s) -> {
            list.add(s);
        });
        return list;
    }

    // Metode som henter en liste over alle skademeldinger knyttet en bestemt bruker(kunde)
    public ArrayList<SkadeMelding> getSkadeMelding(Class forsikring, Bruker b) {
        ArrayList<SkadeMelding> liste = new ArrayList<>();
        register.stream().filter((skade) -> (forsikring.isAssignableFrom(skade.getForsikring().getClass()))).forEach((skade) -> {
            liste.add(skade);
        });
        return liste;
    }

    // finner utgifter på bilforsikringer
    public double finnUtgiftBil( int år ) {
        double sum = 0;
        for(SkadeMelding s : register){
            if(s instanceof BilSkadeMelding && s.getdatoInnmeldt().get(Calendar.YEAR)== år )
                sum+= s.getUtbetaling();
        }
        return sum;
    }
    
    // finner utgifter på båt.
    public double finnUtgiftBåt( int år ) {
        double sum = 0;
        for(SkadeMelding s : register){
            if(s instanceof BatSkadeMelding && s.getdatoInnmeldt().get(Calendar.YEAR)== år )
                sum+= s.getUtbetaling();
        }
        return sum;
    }
    
    //finner utgifter på bolig
    public double finnUtgiftBolig( int år ) {
        double sum = 0;
        for(SkadeMelding s : register){
            if(s instanceof BoligSkadeMelding && s.getdatoInnmeldt().get(Calendar.YEAR)== år )
                sum+= s.getUtbetaling();
        }
        return sum;
    }
    
    //finner utgifter på fritidsbolig
    public double finnUtgiftFritid( int år ) {
        double sum = 0;
        for(SkadeMelding s : register){
            if(s instanceof FritidsBoligMelding && (s.getdatoInnmeldt().get(Calendar.YEAR)== år) )
                sum+= s.getUtbetaling();
        }
        return sum;
    }
    
    // finner utgifter på reise
    public double finnUtgiftReise( int år ) {
        double sum = 0;
        for(SkadeMelding s : register){
            if(s instanceof ReiseSkadeMelding &&  ( s.getdatoInnmeldt().get(Calendar.YEAR)== år ))
                sum+= s.getUtbetaling();
        }
        return sum;
    }
    
    
    // finner totale utgifter for et gitt år
    public double finnUtgiftTotal( int år ) {
        double sum = 0;
        for( SkadeMelding s : register ){
            if( s.getdatoInnmeldt().get(Calendar.YEAR)== år )
                sum+= s.getUtbetaling();
        }
        return sum;
    }


    
}// end of class SkadeMeldingregister
