/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import java.util.Calendar;



/**
 * Inneholder det som er unikt for reiseskademeldinger, foreløpig bare en toString().
 *
 * @author Therese
 */
public class ReiseSkadeMelding extends SkadeMelding{
   
  
   
   public ReiseSkadeMelding(String skadeBeskrivelse , int utbetal, Calendar skadeDato){
        super(skadeBeskrivelse ,  utbetal, skadeDato);
 
   }
   
   public String melding(){
        String s;
        s = "Reiseskademelding \n Innmeldt av\t :"  +"\n"+
                "Forsikringstype: " + "verden\n" +
                super.toString();
        
        return s;
    }
    
}
