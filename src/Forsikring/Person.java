/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Person extends Forsikringer{
    private String fornavn, etternavn, personNr, gateAdr, gateNr, postNr;
    private int tlf;
    
    // kostruktøren brukes når det opprettes bilforsikringsobjekter og båtforsikringsobjekter.
    public Person( String s,int tlf, String fornavn, String  etternavn,String personNr,String gateAdr, String gateNr, String postNr){
        super(s);
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personNr = personNr;
        this.gateAdr = gateAdr;
        this.gateNr = gateNr;
        this.postNr = postNr;  
        this.tlf = tlf; 
    }
    
    public Person(double premie,double egenandel, int tlf, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr){
      super(premie, egenandel);
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
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nForsikringen er registrert på: \n Navn : ");
        sb.append(etternavn);
        sb.append(", ");
        sb.append(fornavn);
        sb.append("\nAdresse : ");
        sb.append(gateAdr);
        sb.append(", ");
        sb.append(gateNr);
        sb.append(", ");
        sb.append(postNr);
        sb.append(".");
        return sb.toString();
    }
    
    
    
}// end of class Person

