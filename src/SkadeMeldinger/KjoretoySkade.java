/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import java.io.Serializable;
import java.util.Calendar;


/**
 *Denne klassen er laget slik at man kan legge til flere kjøretøysskademeldinger, 
 * med lignende informasjon.
 * 
 * @author Therese
 */
public class KjoretoySkade extends SkadeMelding implements Serializable{
    
    
   
   public KjoretoySkade(String skadeBeskrivelse , int utbetal, Calendar skadeDato){
        super(skadeBeskrivelse , utbetal, skadeDato);
   
   }
    
}
