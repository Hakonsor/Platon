/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Forsikring.Forsikringer;
import java.util.List;

/**
 *
 * @author Therese
 */
public class Kunde extends Bruker {
 
    private int kundeNr;
    private String passord;
    private Forsikringer liste;// dette skal vel egentlig være liste over poliseNr.
    
    public Kunde(String fornavn, String etternavn,String fakturaAdr, String personNr, String passord){
        super( fornavn,  etternavn, fakturaAdr,  personNr, passord);
        this.passord = passord; 
    }
    
     
    public String toString(){
        
    return "hee";
    }
    
}// end of class Kunde
