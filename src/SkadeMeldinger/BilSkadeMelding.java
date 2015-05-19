/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.BilForsikring;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

/**
 * Inneholder det som er unikt for bilskademelding, som nå bare er en
 * toString(), men er et viktig ledd i polymorfisme, og er laget slik, sånn at
 * skademeldinger for bil, lett kan utvides.
 *
 * @author Therese
 */
public class BilSkadeMelding extends KjoretoySkade implements Serializable {

    public BilSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);
    }

    // meldingen som vises for skadebehandler når han behandler skadene
    public String melding() {
        BilForsikring f = (BilForsikring) super.getForsikring();
        String form = "0.00";
        DecimalFormat tall = new DecimalFormat(form);
        NumberFormat prosent = NumberFormat.getPercentInstance();
        prosent.setMinimumFractionDigits(0);
        String s;
        s = "Bilskademelding \nInnmeldt av: " + f.getKunde().getFornavn() + " " + f.getKunde().getEtternavn() + "\n"
                +"Bilen eies av : \n"; 
        if(f.getperson()!=null){
                  s+=  f.getperson().getFornavn() + " "  +f.getperson().getEtternavn() ;
                }
        else{
           s+= f.getKunde().getFornavn() + " " + f.getKunde().getEtternavn() ;
        }
                s+= "RegNO: " + f.getRegNr() + "\n" + super.toString()
                + "\nPremie før skade: " + tall.format(f.getPremie()) + " kr"
                + "\nPremie etter skade: " + tall.format(f.getPremieTilGodkjenning()) + " kr"
                + "\nBonus før skade : " + prosent.format(f.getBonus()/100)
                + "\nBonus etter skade: " + prosent.format(f.getBonusTilGodkjenning()/100);
        return s;
    }
}
