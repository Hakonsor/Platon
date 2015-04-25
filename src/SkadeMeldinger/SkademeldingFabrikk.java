/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Forsikring.Forsikringer;
import Forsikring.ReiseForsikring;

/**
 *
 * @author Therese
 */
public class SkademeldingFabrikk {
    
  
 // lager skademeldinger klar til å motta informasjon fra brukeren
    public SkadeMelding lagSkadeMelding(Forsikringer fors){
        SkadeMelding skade;
        if(fors instanceof BilForsikring){
           skade = new BilSkadeMelding(); 
           skade.setForsikring(fors);
        }
        else if(fors instanceof BatForsikring){
           skade = new BatSkadeMelding();
           skade.setForsikring(fors);
        }
        else if(fors instanceof BoligForsikring){
           skade =  new BoligSkadeMelding();
           skade.setForsikring(fors);
        }
        else if(fors instanceof ReiseForsikring){
            skade = new PersonSkadeMelding();
            skade.setForsikring(fors);
        }
        return null;
    }// end of method lagSkadeMelding
       
   
}// end of class SkadeMeldingFabrikk
