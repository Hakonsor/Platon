/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Forsikring.Forsikringer;
import Forsikring.ForsikringsRegister;
import Forsikring.FritidsBolig;
import Forsikring.ReiseForsikring;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Therese
 */
public class Kunde extends Bruker implements Serializable {
    
    private int kundeNr;
    private static int nesteKundeNr;
    private String passord, telefon;
    private Forsikringer liste;// dette skal vel egentlig vÃ¦re liste over poliseNr.
    private ForsikringsRegister register;
    
    public Kunde( String fornavn, String etternavn, String adr, String postNr, String telefon, String personNr, String passord){
        super(fornavn,etternavn,personNr,adr, postNr, passord, telefon);
        this.passord = passord; 
        this.telefon = telefon;
        kundeNr = ++nesteKundeNr;
        register = new ForsikringsRegister();
    }


    public String getNøkkel(){
        return Integer.toString(kundeNr);
    }
    
    public int getKundeNr(){
        return kundeNr;
    }
}// end of class Kunde





    
    
    
    
    

        
    

     
    
    

