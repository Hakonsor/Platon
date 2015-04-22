/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring ;

import Forsikring.Person;

/**
 *
 * @author Therese, Håkon
 */
public class ReiseForsikring extends Person{
    
    public ReiseForsikring(String s, int premie , int egenandel, int tlf , String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr){
        super( s, tlf, fornavn, etternavn, personNr, gateAdr, gateNr, postNr);
    }
    
}
