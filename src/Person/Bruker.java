/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Person;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author hakon_000
 */
 abstract public class Bruker {
    private String fornavn, etternavn, fakturaAdr, personNr;
    private ArrayList<Integer> forsikringListe;// dette skal vel egentlig være liste over poliseNr.
    private Calendar opprettetDato;
    
    public Bruker(String fornavn, String etternavn,String fakturaAdr, String personNr){
        fornavn = this.fornavn;
        etternavn = this.etternavn;
        fakturaAdr = this.fakturaAdr;
        personNr = this.personNr;
        opprettetDato = Calendar.getInstance();
    }
    public void addForsikring(int forsikring){
        forsikringListe.add(forsikring);
    }
        /*
    public int getForsikring(int polisnr){
        
           for(int i = 0; i < forsikringListe.size(); i++) 
             if(forsikringListe.get(i) == polisnr)
                return forsikringListe.get(i);
        return -1;
    }*/
 
 }