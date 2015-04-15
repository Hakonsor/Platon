/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Person extends Forsikringer{
    private String fornavn, etternavn, personNr, gateAdr, gateNr, postNr;
    private int tlf;
    public Person(int premie , int egenandel, int tlf , String forsikrBet, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr){
      super( premie , egenandel , forsikrBet );
      this.fornavn = fornavn;
      this.etternavn = etternavn;
      this.personNr = personNr;
      this.gateAdr = gateAdr;
      this.gateNr = gateNr;
      this.postNr = postNr;  
      this.tlf = tlf; 
    }
    public int getTlf(){
       return tlf;
    }
    public String getFornavn(){
       return fornavn;
    }
    public String getEtternavn(){
       return etternavn;
    }
    public String getPersonNr(){
       return personNr;
    }
    public String getGateAdr(){
       return gateAdr;
    }
    public String getGateNr(){
       return personNr;
    }
    public String getPostNr(){
       return gateAdr;
    }
    
    
    
}// end of class Person
