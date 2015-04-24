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
    private String fornavn, etternavn, personNr, gateAdr, postNr;
    private int tlf;
    
    
    public Person(int tlf, String fornavn, String etternavn, String personNr, String gateAdr, String postNr){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personNr = personNr;
        this.gateAdr = gateAdr;
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
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nForsikringen er registrert på: \n Navn : ");
        sb.append(etternavn);
        sb.append(", ");
        sb.append(fornavn);
        sb.append("\nAdresse : ");
        sb.append(gateAdr);
        sb.append(", ");
        sb.append(postNr);
        sb.append(".");
        return sb.toString();
    }
    
    
    
}// end of class Person

