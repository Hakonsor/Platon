/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import Forsikring.ReiseForsikring;
import java.util.Calendar;



/**
 * Inneholder det som er unikt for reiseskademeldinger, foreløpig bare en toString().
 *
 * @author Therese
 */
public class ReiseSkadeMelding extends SkadeMelding{
   
  
   
   public ReiseSkadeMelding(String skadeBeskrivelse , int utbetal, Calendar skadeDato){
        super(skadeBeskrivelse ,utbetal, skadeDato);
 
   }
   
   public String melding(){
        String s;
        ReiseForsikring f = (ReiseForsikring)getForsikring();
        s = "Reiseskademelding \nInnmeldt av:\t" + super.getForsikring().getKunde().getFornavn() +" "+super.getForsikring().getKunde().getEtternavn() +"\n"+
             "Forsikringstype: " +f.getType()+ "\n" +
              super.toString();
        
        return s;
    }
    
}
