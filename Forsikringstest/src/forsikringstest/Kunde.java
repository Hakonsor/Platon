/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

import java.util.List;

/**
 *
 * @author Therese
 */
public class Kunde {
    private String fornavn, etternavn, fakturaAdr, personNr;
    private int kundeNr;
    private Forsikringer liste;// dette skal vel egentlig være liste over poliseNr.
    
    public Kunde(String fornavn, String etternavn,String fakturaAdr, String personNr){
        fornavn = this.fornavn;
        etternavn = this.etternavn;
        fakturaAdr = this.fakturaAdr;
        personNr = this.personNr;
    }
     
    
}// end of class Kunde
