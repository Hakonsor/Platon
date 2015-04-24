/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class LivsForsikring extends Forsikringer implements Serializable{  
    public LivsForsikring( int premie , int egenandel, int tlf , String forsikrBet, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr){
        super( premie, egenandel);
    }
    
    
}// end of class LivsForsikring
