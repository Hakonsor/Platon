/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class Person implements Serializable{
    private String fornavn, etternavn, personNr, telefon, epost, gateAdr, postNr;
 
    public Person(){
    
    }

    public Person(String fornavn, String etternavn){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }
    
    public Person( String fornavn, String etternavn, String personNr, String telefon, String epost, String gateAdr, String postNr){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personNr = personNr;
        this.gateAdr = gateAdr;
        this.postNr = postNr;  
        this.telefon = telefon;
        this.epost = epost;
    }
    public String getTlf(){
       return telefon;
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
    public String getPostNr(){
       return postNr;
    }
    public boolean equals(Person p)
   {
     return ( p.getEtternavn().equals( etternavn ) &&
         p.getFornavn().equals( fornavn ) );
   }
    public String getEpost() {return epost;}
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nForsikringen er registrert på: \n Navn: ");
        sb.append(fornavn);
        sb.append(", ");
        sb.append(etternavn);
        sb.append("\nAdresse: ");
        sb.append(gateAdr);
        sb.append(", ");
        sb.append("\nPostNr: ");
        sb.append(postNr);
        sb.append(".");
        return sb.toString();
    }
    
    
    
}// end of class Person

