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
 *
 * @author Therese
 */
public class BilSkadeMelding extends KjoretoySkade implements Serializable{


    public BilSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);
    }
    
    public String melding(){
        String s;
        s = "Bilskademelding \n Innmeldt av\t :" +  super.getForsikring().getKunde().getFornavn() +" "+super.getForsikring().getKunde().getEtternavn()+"\n"+
                  "RegNO: "+ ((BilForsikring)forsikring).getRegNr()+ "\n" +super.toString();
        
        return s;
    }
}
