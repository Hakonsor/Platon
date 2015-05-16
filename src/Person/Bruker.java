/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Person;


import javax.sound.midi.Soundbank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author hakon_000
 */
 abstract public class Bruker extends Person implements Serializable {
    private String fakturaAdr, personNr,passord;
   // private ArrayList<Integer> forsikringListe;// dette skal vel egentlig være liste over poliseNr.
    //private Calendar opprettetDato;
    public Bruker( String passord, String fornavn, String etternavn ){
        super(fornavn, etternavn);
        this.passord = passord;
    }
    public Bruker( String fornavn, String etternavn, String personNr, String telefon, String epost, String gateAdr, String postNr, String passord){
      super(fornavn, etternavn, personNr, telefon, epost, gateAdr, postNr);
        this.passord = passord;
       // opprettetDato = Calendar.getInstance();
    }
  //  public void addForsikring(int forsikring){
        //forsikringListe.add(forsikring);
    
    public boolean sjekkPassord(String passord){
        System.out.println(this.passord +" "+passord);
    return (this.passord.equals(passord));
    }
    
    abstract public String getNøkkel();
    
        /*
    public int getForsikring(int polisnr){
        
           for(int i = 0; i < forsikringListe.size(); i++) 
             if(forsikringListe.get(i) == polisnr)
                return forsikringListe.get(i);
        return -1;
    }*/
 
 }
