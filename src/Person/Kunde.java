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
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Therese
 */
public class Kunde extends Bruker implements Serializable {

    public static int getStaticKundeNr() {
        return nesteKundeNr;
    }

    public static void setStaticKundeNr(int nestekundeNr) {
        nesteKundeNr = nestekundeNr;
    }

    private int kundeNr;
    private static int nesteKundeNr;
    private String passord, telefon, epost;
    private ForsikringsRegister register;
    private boolean aktiv;

    public Kunde(String fornavn, String etternavn, String personNr, String telefon, String epost, String adr, String postNr, String passord) {
        super(fornavn, etternavn, personNr, telefon, epost, adr, postNr, passord);
        this.passord = passord;
        this.telefon = telefon;
        this.epost = epost;
        this.aktiv = true;
        kundeNr = ++nesteKundeNr;
        System.out.println(kundeNr);
    }


    public boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean b) {
        aktiv = b;
    }

    public String getNøkkel() {
        return Integer.toString(kundeNr);
    }
    
    public int getKundeNr(){
        return kundeNr;
    }
    
    @Override
    public boolean sjekkPassord(String passord) {
        System.out.println(this.passord +""+passord);
        return (this.passord.equals(passord) && aktiv);
    }

    public String toString() {
        return Integer.toString(kundeNr);
    }

}// end of class Kunde
