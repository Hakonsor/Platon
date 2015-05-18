/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.BilForsikring;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Inneholder det som er unikt for bilskademelding, som nå bare er en toString(), men er et viktig
 * ledd i polymorfisme, og er laget slik, sånn at skademeldinger for bil, lett kan utvides.
 *
 * @author Therese
 */
public class BilSkadeMelding extends KjoretoySkade implements Serializable{


    public BilSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);
    }
    
    // meldingen som vises for skadebehandler når han behandler skadene
    public String melding(){
        String s;
        s = "Bilskademelding \nInnmeldt av:\t" +  getForsikring().getKunde().getFornavn() +" "+super.getForsikring().getKunde().getEtternavn()+"\n"+
                  "RegNO: "+ ((BilForsikring)getForsikring()).getRegNr()+ "\n" +super.toString();
        
        return s;
    }
}
