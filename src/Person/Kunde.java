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
    
    public Kunde(int tlf, String fornavn, String etternavn,String adr, String postNr,String personNr, String telefon, String passord){
        super(tlf,fornavn,etternavn,personNr,adr, postNr, passord);
        this.passord = passord; 
        this.telefon = telefon;
        kundeNr = ++nesteKundeNr;
        register = new ForsikringsRegister();
    }

    public String getKundeNokkel(){
    return Integer.toString(kundeNr);
    }
    
    // viser en liste over gyldige forsikringer av en bestemt type
    public String visForsikring(int i){
        return register.visListe(i);
    }
    
    public void settInn(Forsikringer f){
        if (f instanceof BilForsikring){
            register.settInn((BilForsikring)f);
            System.out.println(register.visListe(2));
        }
        if (f instanceof BatForsikring){
            register.settInn((BatForsikring)f);
        }
        if (f instanceof BoligForsikring){
            register.settInn((BoligForsikring)f);
        }
        if (f instanceof ReiseForsikring){
            register.settInn((ReiseForsikring)f);
        }
        if (f instanceof FritidsBolig){
            register.settInn((FritidsBolig)f);
        }
    }// end of method settInn
        public List getForsikringsListe(int index) {
            return register.finnListe(index);
        }
        
        public String toString(){
            return Integer.toString(kundeNr);
        }

        
    

     
    
    
}// end of class Kunde
