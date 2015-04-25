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
import java.io.Serializable;

/**
 *
 * @author Therese
 */
public class SkadeMeldingFabrikk implements Serializable{ 
   
    public SkadeMeldingFabrikk(){
       
    }
 // lager skademeldinger klar til å motta 
//informasjon og registrerer Forsikringen som gjelder i skademeldingen
    public static SkadeMelding lagSkadeMelding( Forsikringer fors ){
        if( verifiser ( fors ) ){
            SkadeMelding skade;
            skade = null;
            if( fors instanceof BilForsikring ){
                skade = new BilSkadeMelding(); 
                
            }
            else if( fors instanceof BatForsikring ){
                skade = new BatSkadeMelding();
                
            }
            else if( fors instanceof BoligForsikring ){
                skade =  new BoligSkadeMelding();
                
            }
            else if( fors instanceof ReiseForsikring ){
                skade = new PersonSkadeMelding();
                
            }
            if( skade != null ){
                skade.setForsikring( fors );
            }
            return skade;
       }
        return null;
        
    }// end of method lagSkadeMelding
    
    // skal returnere true dersom forsikringen finnes, hvis ikke false
    // skademeldingen kan dermed ikke opprettes.
    public static  boolean verifiser(Forsikringer fors){
        
        // metoden er under bygging
        return true;
       
    }
    
}// end of class SkadeMeldingFabrikk
