/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

/**
 *
 * @author Therese
 */
public abstract class Person {
    private String kundeNr, fornavn, etternavn, personNr, gateAdr, gateNr, postNr;
    
    public Person(String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr){
      this.fornavn = fornavn;
      this.etternavn = etternavn;
      this.personNr = personNr;
      this.gateAdr = gateAdr;
      this.gateNr = gateNr;
      this.postNr = postNr;  
    }
    

    public void setKundeNr(String kundeNr){
        this.kundeNr = kundeNr;
    }
    
    
}// end of class Person
