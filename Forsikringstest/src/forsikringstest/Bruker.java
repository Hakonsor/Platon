/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forsikringstest;


import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author hakon_000
 */
public class Bruker {
    

    private String fornavn, etternavn, fakturaAdr, personNr;
    private LinkedList<Forsikringer> ForsikringListe;// dette skal vel egentlig være liste over poliseNr.
    private Calendar opprettetDato;
    
    public Bruker(String fornavn, String etternavn,String fakturaAdr, String personNr){
        fornavn = this.fornavn;
        etternavn = this.etternavn;
        fakturaAdr = this.fakturaAdr;
        personNr = this.personNr;
        opprettetDato = Calendar.getInstance();
    }
    public void setForsikring(){
    return;
    
    }

}