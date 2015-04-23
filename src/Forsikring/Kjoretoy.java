/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Kjoretoy extends Person implements Serializable{
    private String regNr , type , modell , arsModell;
    private double bonus;
    
    public Kjoretoy( double bonus, int tlf, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr, String regNr , String type , String modell ,String arsModell ){
        super(tlf, fornavn,  etternavn,  personNr, gateAdr, gateNr, postNr);
        this.bonus= bonus;
        this.regNr = regNr;
        this.type = type;
        this.modell = modell;
        this.arsModell = arsModell;
    }
    public String getRegNr(){
     return regNr;
    }
    public String getType(){
     return type;
    }
    public String getModell(){
     return modell;
    }
    public String getArsModell(){
     return arsModell;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public double getBonus(){
     return bonus;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nKjøretøysforsikring: ");
        sb.append("\nBonus : ");
        sb.append(bonus*100);
        sb.append(" %");
        sb.append("\n");
        sb.append("Registreringsnummer: ");
        sb.append(regNr);
        sb.append("\n");
        sb.append("Merke: ");
        sb.append(type);
        sb.append("\n");
        sb.append("Modell: ");
        sb.append(modell);
        sb.append("\n");
        sb.append("Årsmoell: ");
        sb.append(arsModell);
        sb.append("\n");
        return sb.toString();
    }// end of method toString()   
}// end of class Kjoretoy
